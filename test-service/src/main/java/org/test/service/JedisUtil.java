package org.test.service;


import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * 
 * @Description   redis 分布式锁
 * @date   2017年11月2日 下午2:11:21
 * @author chenwei
 *
 */
public class JedisUtil {

	private Logger logger=Logger.getLogger(this.getClass());
	
	private static final JedisPool pool;
	
	private static final String lockPrefix="REDIS_LOCK:";
	
	static {
		JedisPoolConfig poolConfig=new JedisPoolConfig();
		//jedispool最多可分配多少个实例
		poolConfig.setMaxTotal(500);
		//控制一个pool最多有多少个空闲状态的jedis实例
		poolConfig.setMaxIdle(5);
		//获取jedis实例的等待时间，超过抛出异常
		poolConfig.setMaxWaitMillis(1000*100);
		//是否提前校验实例链接是否可用
		poolConfig.setTestOnBorrow(true);
		
		pool=new JedisPool(poolConfig, "127.0.0.1",6379);
		
	}
	
	public boolean lock(String key) {
		return  lock(key, 30*1000,0) ;
	}
	public boolean tryLock(String key){
		return lock(key, 30*1000,0);
	}
	
	public boolean tryLock(String key, long expireTime){
		return lock(key, expireTime,30*1000);
	}
	
	public boolean lock(String key, long expireTime,Integer waitTime) {
		String  redisKey=lockPrefix+key;
		Jedis jedis=null;
		
		long now= System.currentTimeMillis();
		long expireDate=System.currentTimeMillis()+expireTime;//过期时间
		jedis = pool.getResource();
		try {
			do {
				long retFlag= jedis.setnx(redisKey,String.valueOf(expireDate));
				if (retFlag==1) {
					jedis.expire(redisKey, (int)expireTime/1000);
					return true;
				}
				if (jedis.ttl(redisKey)<0) {
					jedis.expire(redisKey, (int)expireTime/1000);
				}
				if (waitTime<=0) {
					break;
				}
				Thread.sleep(5000);
			} while (System.currentTimeMillis()- waitTime<now);
		}catch (Exception e){
			logger.error(e);
			return false;
		}finally {
			jedis.close();
		}
		return false;
	}

	public void unLock(String key) {
		 String redisKey=lockPrefix+key;
		 Jedis jedis=null;
		 try {
				jedis = pool.getResource();
				String oldValue= jedis.get(redisKey);
				if (oldValue!=null&& System.currentTimeMillis()<Long.parseLong(oldValue)) {
					jedis.del(redisKey);
				}
			}catch (Exception e){
				logger.error(e);
			}finally {
				jedis.close();
			}
	}
}
