package org.test.api;

import java.util.HashMap;
import java.util.Map;

public class ParentApp {

	
	
	private String aaaString="12";
	
	private String bbb="369";
	
	private Map<String, String> map=new HashMap<String, String>();
	
	protected String name() {
		return this.aaaString+this.bbb;
	}
	
	protected void nameMap() {
		map.put("123546", "dsfsaf");
		System.out.println(map);
	}
}
