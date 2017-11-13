package com.labi.consumer;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;

import com.labi.common.MsgType;

public abstract class ConsumerFactory {

	private static ConcurrentHashMap<Destination, Consumer> consumerMaps=new ConcurrentHashMap<Destination, Consumer>();//缓存的消费者
	
	/**
	 * 
	 * @Title: getConsumer
	 * @Description: 得到一个消费者
	 * @param msgType 
	 * @param name
	 * @return 
	 * @throws
	 */
	
	public static Consumer getConsumer(MsgType msgType, String name){
					
		if (msgType==null || name==null) {
			throw new RuntimeException("参数缺失，msgtype="+msgType+"name="+name);
		}
		boolean isGet=false;
		synchronized (consumerMaps) {
			if (consumerMaps.size()>0) {
				Set<Destination> keySet = consumerMaps.keySet();
				Destination destination=null;
				String destinationName="";
				for (Iterator<Destination> iterator = keySet.iterator(); iterator.hasNext();) {
					destination = iterator.next();
					try {
						if (destination instanceof Queue) {
							destinationName = ((Queue) destination).getQueueName();
						}else if(destination instanceof Topic) {
							destinationName = ((Topic)destination).getTopicName();
						}
						if (name.equals(destinationName)) {
							isGet=true;
							return consumerMaps.get(destination);
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				
				}
			}
			
			if (!isGet) {
				Consumer consumer=null;
				if (MsgType.quene.equals(msgType)) {
					consumer=new QueneConsumer(name);
				}else {
					consumer=new TopicConsumer(name);
				}
				consumerMaps.put(consumer.destination, consumer);
				return consumer;
			}
		}
		return null;
	}
	
	
}
