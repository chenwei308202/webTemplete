package com.chen.service.usercenter.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.bean.User;
import com.chen.dao.UserCenterDao;
import com.chen.service.usercenter.UserCenterService;

@Service
public class UserCenterServiceImpl implements UserCenterService {

	@Autowired
	private UserCenterDao userCenterDao;
	
	
	public User getUserById(Integer id) {
		if (id==null) {
			throw new IllegalArgumentException("id is null");
		}
		return userCenterDao.queryBy(new User(id));
	}

	public User getUserByUserName(String userName) {
		
		if (StringUtils.isBlank(userName)) {
			throw new IllegalArgumentException("userName is null");
		}
		return userCenterDao.queryBy(new User(userName));
	}

}
