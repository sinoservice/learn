package com.easyhome.po;

public class AppGetRewardAndPunish {

	/***
	 * 0获取奖的规则明细  1获取罚的规则明细
	 */
	private String type; 
	/**
	 * 第几页
	 */
	private int pageIndex;
	/**
	 * 每页大小
	 */
	private int pageSize;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
