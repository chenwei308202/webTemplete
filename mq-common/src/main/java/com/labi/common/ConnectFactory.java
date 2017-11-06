package com.labi.common;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public  class ConnectFactory {
	
	//用户名
	private static final String USER_NAME=ConnectCfg.DEFAULT_USER_NAME;
	
	//密码
	private static final String PASSWORD=ConnectCfg.DEFAULT_PASSWORD;
	
	//服务器链接地址
	private static final String BROKEURL=ConnectCfg.DEFAULT_BROKEURL;
	
	//连接对象
	private Connection connection;
	
	private Session session;
	
	private Topic topic;
	
	private boolean isRun;
	
	private String topicName;
	
	
	public ConnectFactory(String  topicName){
		this.topicName=topicName;
		init();
	}
	
	
	
	public void init(){
		
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory(USER_NAME, PASSWORD, BROKEURL);
		try {
			connection=connectionFactory.createTopicConnection();
			connection.start();
			//事务关闭 如果开始事务会导致消息无法发出和消费(跟提交有关，未验证) 这是个坑
			session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			topic=session.createTopic(topicName);
			isRun=true;
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}


	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	};
	
}
