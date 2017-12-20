package com.chen.service.usercenter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.bean.SchoolIntroduce;
import com.chen.dao.SchoolIntroduceDao;
import com.chen.service.usercenter.SchoolIntroduceService;

@Service
public class SchoolIntroduceServiceImpl implements SchoolIntroduceService {
	
	@Autowired
	private SchoolIntroduceDao schoolIntroduceDao;

	public SchoolIntroduce getSchoolIntroduce() {
		return schoolIntroduceDao.queryBy();
	}

	public SchoolIntroduce updateSchoolIntroduce(SchoolIntroduce schoolIntroduce) {
		schoolIntroduceDao.update(schoolIntroduce);
		return schoolIntroduce;
	}

	
	
	
}
