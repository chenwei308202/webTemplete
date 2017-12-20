package com.chen.service.usercenter.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.bean.Notice;
import com.chen.bean.Page;
import com.chen.dao.SchoolNoticeDao;
import com.chen.service.usercenter.SchoolNoticeService;

@Service
public class SchoolNoticeServiceImpl implements SchoolNoticeService {

	
	

	@Autowired
	private SchoolNoticeDao schoolNoticeDao;
	
	public Page getNoticeByPage(Page pageNotice) {
		pageNotice.calcul();
		pageNotice.setPageTotal(schoolNoticeDao.queryCount(pageNotice));
		List<Notice> noticeList = schoolNoticeDao.queryBy(pageNotice);
		
		pageNotice.setList(noticeList);
		
		return pageNotice;
	}

	public void addNotice(Notice notice) {
		schoolNoticeDao.insertOne(notice);
		
	}

	public void updateNotice(Notice notice) {
		schoolNoticeDao.updateOne(notice);
		
	}

	public Notice getNoticeById(Integer id) {
		Page page= new Page();
		page.setId(id);
		List<Notice> notices=schoolNoticeDao.queryBy(page);
		if (CollectionUtils.isNotEmpty(notices)) {
			return notices.get(0);
		}
		return null;
	}

}
