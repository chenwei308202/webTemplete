package com.labi.consumer;


import javax.jms.JMSException;
import javax.jms.Topic;

import com.labi.common.ConnectFactory;



public class TopicConsumer extends AbstractMsgConsumer{

	private String topicName;
	
	TopicConsumer(String topicName) {
		if (topicName==null) {
			throw new RuntimeException("topic不能为空");
		}
		this.topicName=topicName;
		try {
			Topic topic =ConnectFactory.getSession().createTopic(this.getTopicName());
			this.destination=topic;
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

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}
