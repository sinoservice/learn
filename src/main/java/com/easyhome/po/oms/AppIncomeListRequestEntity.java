package com.easyhome.po.oms;

import java.io.Serializable;

public class AppIncomeListRequestEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String masterId;// 技师编码
	private String date;// 时间
	private int pageIndex;// 第几页
	private int pageSize;// 每页大小

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
