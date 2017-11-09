package com.labi;

import com.labi.common.MsgType;
import com.labi.consumer.ConsumerFactory;

public class MqReceiveTest {

	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			public void run() {
				while (true) {
					String msgBody= ConsumerFactory.getConsumer(MsgType.quene,"LIST_BASEINFO").receiveTextMessage();
					System.out.println(msgBody);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
}
