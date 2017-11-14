package com.labi;

import java.util.Random;

import com.labi.common.MsgType;
import com.labi.provider.ProviderFactory;

public class MqProducerTest {

	
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			try {
				ProviderFactory.getProvider(MsgType.quene,"testMM").SendTextMessage("哈利路亚");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
