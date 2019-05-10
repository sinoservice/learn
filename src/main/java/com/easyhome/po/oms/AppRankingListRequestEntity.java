package com.easyhome.po.oms;

import java.io.Serializable;

public class AppRankingListRequestEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String date;// 时间
	private int pageIndex;// 第几页
	private int pageSize;// 每页大小
	private String masterId;//技师代码
	private String status;//排序类型1-完成订单数2--好评率3---收益
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

}
