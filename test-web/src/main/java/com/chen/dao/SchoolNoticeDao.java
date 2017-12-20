package com.chen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chen.bean.Notice;
import com.chen.bean.Page;

@Repository
public interface SchoolNoticeDao {

	public Integer queryCount(Page page);
	
	public List<Notice> queryBy(Page page);

	public void insertOne(Notice notice);

	public void updateOne(Notice notice);
}
