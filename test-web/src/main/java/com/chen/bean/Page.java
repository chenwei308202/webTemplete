package com.chen.bean;

import java.util.List;

public class Page {

	private List<Notice> list;
	
	private Integer id;
	
	
	private Integer pageIndex;
	
	private Integer pageNum=1;
	
	private Integer pageSize=20;
	
	private Integer pageTotal;
	
	

	
	
	public Integer getPageTotal() {
		return pageTotal;
	}

	public Page setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
		return this;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public Page setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
		calcul();
		return this;
	}

	public List<Notice> getList() {
		return list;
	}

	public void setList(List<Notice> list) {
		this.list = list;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public Page setPageIndex(Integer pageIndex) {
		
		this.pageIndex = pageIndex;
		return this;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Page setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		calcul();
		return this;
	}
	
	public void calcul(){
		if (this.getPageNum()!=null && this.getPageSize()!=null) {
			this.setPageIndex((this.getPageNum()-1)*this.getPageSize());
		}
	};
	
}
