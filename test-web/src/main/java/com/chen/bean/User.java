package com.chen.bean;

public class User {

	
	private Integer id;
	
	private String userName;
	
	private String password;
	
	private String createDate;

	
	
	public User(String userName) {
		super();
		this.userName = userName;
	}

	public User(Integer id) {
		super();
		this.id = id;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String userName, String password, String createDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
