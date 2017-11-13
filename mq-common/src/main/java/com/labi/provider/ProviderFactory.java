package com.labi.provider;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;

import com.labi.common.MsgType;

public abstract class ProviderFactory {

	private static ConcurrentHashMap<Destination, Provider> providerMaps=new ConcurrentHashMap<Destination, Provider>();
	
	/**
	 * 
	 * @Title: getProvider
	 * @Description: 得到一个点对点模式的生产者
	 * @param msgType 
	 * @param name
	 * @return 
	 * @throws
	 */
	public  static Provider getProvider(MsgType msgType, String name){
		if (msgType==null || name==null) {
			throw new RuntimeException("参数缺失，msgtype="+msgType+"name="+name);
		}
		boolean isGet=false;
		synchronized (providerMaps) {
			if (providerMaps.size()>0) {
				Set<Destination> keySet = providerMaps.keySet();
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
							return providerMaps.get(destination);
						}
					} catch (JMSException e) {
						e.printStackTrace();
					}
				
				}
			}
			
			if (!isGet) {//这块还是有问题，后续再说
				Provider provider=null;
				if (MsgType.quene.equals(msgType)) {
					provider=new QueueProvider(name);
				}else {
					provider=new TopicProvider(name);
				}
				providerMaps.put(provider.destination, provider);
				return provider;
			}
		}
		return null;
	}
	
	
	
	
}
