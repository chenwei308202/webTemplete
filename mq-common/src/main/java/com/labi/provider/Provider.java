package com.labi.provider;

import javax.jms.Destination;


public abstract class Provider {
	
	public abstract void  SendTextMessage(Object message);
	
	protected Destination destination;

}
