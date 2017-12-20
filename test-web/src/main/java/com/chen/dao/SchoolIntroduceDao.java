package com.chen.dao;

import org.springframework.stereotype.Repository;

import com.chen.bean.SchoolIntroduce;

@Repository
public interface SchoolIntroduceDao {

	public SchoolIntroduce queryBy();

	public void update(SchoolIntroduce schoolIntroduce);
}
