package com.labi;

import com.labi.common.LabiTopic;
import com.labi.consumer.MsgReceiver;

public class MqReceiveTest {

	
	public static void main(String[] args) {
		while (true) {
			
			MsgReceiver msgReceiver= MsgReceiver.getInstance(LabiTopic.RONG_BASEINFO);
			
			String textString= msgReceiver.receiveMessage();
			System.out.println("消费者hashcode："+msgReceiver.hashCode());
			System.out.println(textString);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
