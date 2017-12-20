package com.labi;

import com.labi.common.MsgType;
import com.labi.consumer.ConsumerFactory;

public class MqReceiveTest {

	
	public static void main(String[] args) {

		new Thread(new Runnable() {
			
			public void run() {
				while (true) {
					try {
						
						String msgBody= ConsumerFactory.getConsumer(MsgType.quene,"LIST_BASEINFO").receiveTextMessage();
						System.out.println(msgBody);
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
}
