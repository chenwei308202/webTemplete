package com.chen.service.usercenter;

import com.chen.bean.Notice;
import com.chen.bean.Page;

public interface SchoolNoticeService {

	
	
	public Page getNoticeByPage(Page pageNotice);

	public void addNotice(Notice notice);

	public void updateNotice(Notice notice);

	public Notice getNoticeById(Integer id);
}
