package com.labi.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

import com.labi.common.ConnectFactory;

public  class MqMsgSubScriber extends MsgReceiver {
	
	
	
	private ConnectFactory connectFactory;
	
	private MessageConsumer messageConsumer;
	
	protected MqMsgSubScriber(String topicName){
		this.topicName=topicName;
		connectFactory=new ConnectFactory(topicName);
	}
	
	protected MessageConsumer getSubScriber(){
		if (!connectFactory.isRun()) {
			throw new RuntimeException("mq server is not running");
		}
		
		if (messageConsumer==null) {
			try {
				messageConsumer= connectFactory.getSession().createConsumer(connectFactory.getTopic());
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		return messageConsumer;
	}

	public String receiveMessage() {
		
		try {
			 Message message=this.getSubScriber().receive();
			 if (message!=null) {
				
			 TextMessage textMessage=(TextMessage)message;	
			 return textMessage.getText();
			 }
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
