package com.labi.consumer;

import javax.jms.Destination;


public abstract class Consumer {
	
	protected Destination destination;

	public abstract String receiveTextMessage();
	
}
