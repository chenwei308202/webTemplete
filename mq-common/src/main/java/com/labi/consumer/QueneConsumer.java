package com.labi.consumer;

import javax.jms.JMSException;
import javax.jms.Queue;

import com.labi.common.ConnectFactory;

public class QueneConsumer extends AbstractMsgConsumer{
	
	private String queueName;
	
	protected QueneConsumer(String queueName){
		if (queueName==null ) {
			throw new RuntimeException("queneName不能为空");
		}
		this.queueName=queueName;
		try {
			Queue queue = ConnectFactory.getSession().createQueue(this.getQueneName());
			this.destination=queue;
		} catch (JMSException e2) {
			e2.printStackTrace();
			throw new RuntimeException("初始化session异常",e2);
		}
		try {
			this.messageConsumer=(ConnectFactory.getSession().createConsumer(this.destination));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public String getQueneName() {
		return queueName;
	}

	public void setQueneName(String queneName) {
		this.queueName = queneName;
	}

	
}
