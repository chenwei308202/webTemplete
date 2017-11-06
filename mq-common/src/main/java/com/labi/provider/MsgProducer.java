package com.labi.provider;

import com.labi.common.LabiTopic;


public abstract class MsgProducer {

	
	private static MsgProducer producer;
	
	String topicName;
	
	/**
	 * 
	 * @Title: getInstance
	 * @Description: 获取单实例发送者
	 * @param topicEnum 主题
	 * @return 
	 * @throws
	 */
	public synchronized static MsgProducer getInstance(LabiTopic topicEnum){
		
		if (producer==null || !producer.topicName.equals(topicEnum.toString())) {
			producer=new MqMsgPublisher(topicEnum.toString());
		}
		return producer;
	}
	
	public abstract void  SendMessage(Object message) ;

}
