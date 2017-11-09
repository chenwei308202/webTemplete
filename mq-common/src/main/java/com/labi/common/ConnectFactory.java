package com.labi.common;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.labi.consumer.AbstractMsgConsumer;
import com.labi.consumer.Consumer;
import com.labi.consumer.QueneConsumer;
import com.labi.consumer.TopicConsumer;
import com.labi.provider.AbstractMsgProducer;

public  class ConnectFactory {
	
	//用户名
	private static final String USER_NAME=ConnectCfg.DEFAULT_USER_NAME;
	
	//密码
	private static final String PASSWORD=ConnectCfg.DEFAULT_PASSWORD;
	
	//服务器链接地址
	private static final String BROKEURL=ConnectCfg.DEFAULT_BROKEURL;
	
	private static boolean isRun;
	private static  Connection connection;
	
	private static Session session;
	
	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		ConnectFactory.connection = connection;
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		ConnectFactory.session = session;
	}

	static{
		if (isRun) {
			throw new RuntimeException("mq服务连接已经启动");
		}
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory(USER_NAME, PASSWORD, BROKEURL);
		try {
			connectionFactory.setUseAsyncSend(true);//异步发送，不等待服务器回执
			connectionFactory.setProducerWindowSize(10240000);//发送端在累积发送了10m左右的数据时，等待服务器进行回执
			connection=connectionFactory.createConnection();
			session= ConnectFactory.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);
//			if (consumer!=null) {
//				
//				if (consumer instanceof TopicConsumer) {
//					if (((TopicConsumer)consumer).getClientId()==null) {
//						throw new RuntimeException("clientID不能为空");
//					}else {
//						connection.setClientID(((TopicConsumer)consumer).getClientId());
//					}
//				}else {
//				}
//				consumer.setConnection(connection);
//			}
//			if (provider!=null) {
//				
//			}
//			Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			isRun=true;
			
		} catch (JMSException e) {
			throw new RuntimeException("mq服务初始化异常", e);
		}
	}



	

}
