package com.chen.bean;

import java.util.Date;

/**
 * 
 * @Description   学校概况
 * @date   2017年12月13日 下午3:06:20
 * @author chenwei
 *
 */
public class SchoolIntroduce {

	private Integer id;
	
	private String headName;
	
	private String schoolImg;
	
	private String textBody;
	
	private Date createDate;
	
	private Integer status;
	
	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeadName() {
		return headName;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public String getSchoolImg() {
		return schoolImg;
	}

	public void setSchoolImg(String schoolImg) {
		this.schoolImg = schoolImg;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	
}
