package com.labi.provider;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

import com.labi.common.ConnectFactory;


public abstract class AbstractMsgProducer extends Provider{

	
	protected MessageProducer messageProducer;
	
	
	public void SendTextMessage(Object message) {
		
		if (message==null) {
			throw new RuntimeException("message is null");
		}
		if (message instanceof String) {
			try {
				TextMessage textMessage =ConnectFactory.getSession().createTextMessage((String)message);
				this.messageProducer.send(textMessage);
				this.messageProducer.close();
			} catch (JMSException e) {
				e.printStackTrace();
				throw new RuntimeException("发送消息异常");
			}
		}else {
			throw new RuntimeException("非文本消息类型异常");
		}
	}
	

}
