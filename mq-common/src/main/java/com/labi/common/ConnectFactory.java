package com.labi.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public  class ConnectFactory {
	private static boolean isRun;
	private static  Connection connection;
	
	private static Session session;
	
	private static Integer reTryTimes=3;
	
	public static Connection getConnection() {
		checkConnect();
		return connection;
	}

	public static void setConnection(Connection connection) {
		ConnectFactory.connection = connection;
	}

	public static Session getSession() {
		checkConnect();
		return session;
	}

	public static void setSession(Session session) {
		ConnectFactory.session = session;
	}

	static{
		
		init();
	}

	public static  void init(){
		if (isRun) {
			throw new RuntimeException("mq服务连接已经启动");
		}
		
		Properties serverProp=new Properties();
		try {
			InputStream propertiesInput = ConnectFactory.class.getResourceAsStream("mq_cfg.properties");
			serverProp.load(propertiesInput);
		} catch (IOException e1) {
			throw new RuntimeException("加载mq配置文件异常", e1);
		}
		
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory(serverProp.getProperty("user_name"), serverProp.getProperty("password"), serverProp.getProperty("broke_url"));
		try {
			connectionFactory.setUseAsyncSend(true);//异步发送，不等待服务器回执
			connectionFactory.setProducerWindowSize(10240000);//发送端在累积发送了10m左右的数据时，等待服务器进行回执
			connection=connectionFactory.createConnection();
			session= ConnectFactory.getConnection().createSession(false, Session.AUTO_ACKNOWLEDGE);
			connection.start();
			isRun=true;
			
		} catch (JMSException e) {
			throw new RuntimeException("mq服务初始化异常", e);
		}
	}
	
	/**
	 * 
	 * @Title: checkConnect
	 * @Description: 检测链接是否已经断开
	 * @throws
	 */
	public static void checkConnect() {
		if (connection==null || session==null) {
			isRun=false;
			init();
		}
	}

	

}
