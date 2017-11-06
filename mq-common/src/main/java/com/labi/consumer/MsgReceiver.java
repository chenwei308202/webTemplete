package com.labi.consumer;

import com.labi.common.LabiTopic;


public abstract class MsgReceiver {

	
	private static MsgReceiver receiver;
	
	String topicName;
	
	public synchronized static MsgReceiver getInstance(LabiTopic topicEnum){
		
		if (receiver==null || !receiver.topicName.equals(topicEnum.toString())) {
			receiver=new MqMsgSubScriber(topicEnum.toString());
		}
		return receiver;
	}
	
	public abstract String receiveMessage();
}
