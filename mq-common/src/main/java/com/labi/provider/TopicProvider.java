package com.labi.provider;

import javax.jms.JMSException;
import javax.jms.Topic;

import com.labi.common.ConnectFactory;

public class TopicProvider extends AbstractMsgProducer {
	
	

	private String topicName;
	
	protected TopicProvider(String topicName) {
		this.topicName=topicName;
		
		try {
			Topic topic =ConnectFactory.getSession().createTopic(this.getTopicName());
			this.destination=topic;
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

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
}
