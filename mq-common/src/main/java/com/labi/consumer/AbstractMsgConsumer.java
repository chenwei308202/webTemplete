package com.labi.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;


public abstract class AbstractMsgConsumer extends Consumer{
	
	
	protected MessageConsumer messageConsumer;
	
	public String receiveTextMessage() {
		try {
			 Message message=this.messageConsumer.receive();
			 if (message!=null && message instanceof TextMessage) {
				 TextMessage textMessage=(TextMessage)message;	
				 String textString= textMessage.getText();
				 messageConsumer.close();
				 return textString;
			 }else {
				 throw new RuntimeException("非文本类型的消息异常");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}


}
