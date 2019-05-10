package com.easyhome.vo;

import java.io.Serializable;

/**
 * 
 * <p> Title: ReminderWorkOrderQuery</p>
 * <p> Description: 催单查询</p>
 * 
 * @date 2016年6月3日 下午3:54:52
 * @version 1.0
 *
 */
public class ReminderWorkOrderQuery implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8826232480060206053L;
	private String workNo;
	private String overtime;
	
	private int pageSize;
	private int currentPage;
	
	private PageQuery pageQuery;

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getOvertime() {
		return overtime;
	}

	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
