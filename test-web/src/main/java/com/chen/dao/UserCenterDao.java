package com.chen.dao;

import org.springframework.stereotype.Repository;

import com.chen.bean.User;

@Repository
public interface UserCenterDao {

	
	public User queryBy(User user);
}
