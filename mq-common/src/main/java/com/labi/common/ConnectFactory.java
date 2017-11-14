package com.labi.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.log4j.Logger;

public  class ConnectFactory {
	
	private static Logger logger=Logger.getLogger(ConnectFactory.class);
	
	private static boolean isRun;
	private static  Connection connection;
	
	private static Session session;
	
	private static Properties serverProp=new Properties();
	
	private static int reTryTimes=3;//重试次数
	
	private static long downTimeStamp=0;//服务不可用时间戳
	
	private static final long timePeriod=60000;
	
	public static Connection getConnection() {
		checkConnect();
		return connection;
	}

	public static void setConnection(Connection connection) {
		ConnectFactory.connection = connection;
	}

	public static Session getSession() {
		checkConnect();
		return session;
	}

	public static void setSession(Session session) {
		ConnectFactory.session = session;
	}

	static{
		
		try {
			InputStream propertiesInput = ConnectFactory.class.getResourceAsStream("mq_cfg.properties");
			serverProp.load(propertiesInput);
		} catch (IOException e1) {
			throw new RuntimeException("加载mq配置文件异常", e1);
		}
		init();
	}

	public synchronized static  void init(){
		if (isRun) {
			throw new RuntimeException("mq服务连接已经启动");
		}
		
		if (reTryTimes==0 && (System.currentTimeMillis()-downTimeStamp>timePeriod)) {
			reTryTimes=3;
		}
		
		while (reTryTimes!=0||(reTryTimes==0 && (System.currentTimeMillis()-downTimeStamp>timePeriod))) {
			
			ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory(serverProp.getProperty("user_name"), serverProp.getProperty("password"), serverProp.getProperty("broke_url"));
			try {
				connectionFactory.setUseAsyncSend(true);//异步发送，不等待服务器回执
				connectionFactory.setProducerWindowSize(10240000);//发送端在累积发送了10m左右的数据时，等待服务器进行回执
				connection=connectionFactory.createConnection();
				session= ConnectFactory.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
				connection.start();
				isRun=true;
				break;
			} catch (JMSException e) {
				
				reTryTimes--;
				if (reTryTimes==0) {
					logger.error("mq服务连接失败，重试后扔无法连接");
					downTimeStamp=System.currentTimeMillis();
					throw new RuntimeException("mq服务初始化异常", e);
				}else {
					logger.error("mq服务连接失败，正在进行重试", e);
				}
			}
		}
	}
	
	/**
	 * 
	 * @Title: checkConnect
	 * @Description: 检测链接是否已经断开
	 * @throws
	 */
	public synchronized static void checkConnect() {
		
		if (connection==null || session==null||((ActiveMQConnection)connection).isClosed()|| ((ActiveMQSession)session).isClosed()) {
			isRun=false;
			init();
		}
	}

	

}
