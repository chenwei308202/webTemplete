package com.labi.provider;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import com.labi.common.ConnectFactory;
import com.labi.provider.MsgProducer;

public class MqMsgPublisher extends MsgProducer {
	
	

	private ConnectFactory connectFactory;
	
	private MessageProducer messageProducer;
	
	protected MqMsgPublisher(String topicName){
		this.topicName=topicName;
		connectFactory=new ConnectFactory(topicName);
	}
	
	protected MessageProducer getProducer(){
		if (!connectFactory.isRun()) {
			throw new RuntimeException("mq server is not running");
		}
		try {
			if (messageProducer==null) {
				messageProducer=connectFactory.getSession().createProducer(connectFactory.getTopic());
				messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
			}
			return messageProducer;
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void SendMessage(Object message) {
		
		if (message==null) {
			throw new RuntimeException("message is null");
		}
		if (message instanceof String) {
			SendTextMessage((String)message);
		}
	}
	
	private void SendTextMessage(String messageStr ){
	 	try {
			TextMessage textMessage = connectFactory.getSession().createTextMessage(messageStr);
			this.getProducer().send(textMessage);
		} catch (JMSException e) {
			throw new RuntimeException("create textMessage exception", e);
		}
	}
}
