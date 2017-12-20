package com.chen.bean;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 
 * @Description   学校公告
 * @date   2017年12月14日 上午10:18:21
 * @author chenwei
 *
 */
public class Notice {

	
	private Integer id;
	
	
	private String noticeHead;
	
	private String noticeUrl;
	
	private String noticeBody;
	
	private Date createDate;
	
	private String dateStr;
	
	
	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	private Integer isDel;
	
	private String imgSrc;
	
	private String statusDesc;
	
	

	public String getStatusDesc() {
		if (isDel!=null) {
			if (isDel==0) {
				this.statusDesc="正常展示";
			}else {
				this.statusDesc="已下架";
			}
		}
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoticeHead() {
		return noticeHead;
	}

	public void setNoticeHead(String noticeHead) {
		this.noticeHead = noticeHead;
	}

	public String getNoticeUrl() {
		return noticeUrl;
	}

	public void setNoticeUrl(String noticeUrl) {
		this.noticeUrl = noticeUrl;
	}

	public String getNoticeBody() {
		return noticeBody;
	}

	public void setNoticeBody(String noticeBody) {
		this.noticeBody = noticeBody;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
		if (createDate!=null) {
			this.setDateStr(DateFormatUtils.format(this.getCreateDate(), "yyyy-MM-dd HH:mm:ss"));
		}
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	
}
