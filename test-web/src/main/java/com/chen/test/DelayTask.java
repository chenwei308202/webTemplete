package com.chen.test;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class DelayTask implements Delayed {
	
	private String name;
	
	private Integer age;
	
	private Long delayTime;
	
	
	

	public DelayTask(String name, Integer age, Long delayTime) {
		super();
		this.name = name;
		this.age = age;
		this.delayTime = System.currentTimeMillis()+delayTime;
	}

	public int compareTo(Delayed o) {
		
		return this.age-((DelayTask)o).age;
	}

	public long getDelay(TimeUnit unit) {
		
		return unit.convert(this.delayTime-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	public void say(){
		System.out.println("我的自我介绍"+this.name+","+this.age+","+DateFormatUtils.format(this.delayTime, "yyyy-MM-dd HH:mm:ss"));
	}
}
