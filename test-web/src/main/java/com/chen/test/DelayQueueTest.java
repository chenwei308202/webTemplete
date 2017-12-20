package com.chen.test;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

public class DelayQueueTest {

	
	public static void main(String[] args) {
		
		DelayQueue<Delayed> queue=new DelayQueue<Delayed>();
		DelayTask task=null;
		for (int i = 0; i < 50; i++) {
			task=new DelayTask("小花"+i, new Random().nextInt(100), (long)new Random().nextInt(100000));
			queue.add(task);
		}
		
		while (true) {
			try {
				task = (DelayTask)queue.take();
				task.say();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
}
