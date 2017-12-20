package com.chen.service.usercenter;

import com.chen.bean.User;

public interface UserCenterService {

	
	
	public User getUserById(Integer id);
	
	public User getUserByUserName(String userName);
	
}
