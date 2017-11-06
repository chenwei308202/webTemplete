package com.labi;

import com.labi.common.LabiTopic;
import com.labi.provider.MsgProducer;

public class MqProducerTest {

	
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			
			MsgProducer.getInstance(LabiTopic.RONG_BASEINFO).SendMessage("我说yes你说no");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
