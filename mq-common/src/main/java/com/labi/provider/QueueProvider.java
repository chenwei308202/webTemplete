package com.labi.provider;

import javax.jms.JMSException;
import javax.jms.Queue;

import com.labi.common.ConnectFactory;

public class QueueProvider extends AbstractMsgProducer{
	
	
	private String queueName;
	
	protected QueueProvider(String queueName) {
		this.queueName=queueName;
		
		try {
			Queue queue = ConnectFactory.getSession().createQueue((this.getQueueName()));
			this.destination=queue;
		} catch (JMSException e1) {
			e1.printStackTrace();
			throw new RuntimeException("初始化消费者异常");
		}
		try {
			this.messageProducer=(ConnectFactory.getSession().createProducer(this.destination));
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	
	
}
