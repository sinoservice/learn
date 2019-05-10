package com.easyhome.vo;

import java.io.Serializable;

/**
 * 
 * <p> Title: SatisfiedByMasterQuery</p>
 * <p> Description: 技师评价查询</p>
 * 
 * @date 2016年5月27日 下午3:35:31
 * @version 1.0
 *
 */
public class SatisfiedByMasterQuery implements Serializable{
	
	private static final long serialVersionUID = 6766142060341276250L;
	
	private String province;
	//调度平台
	private String platform;
	//完工日期开始
	private String start;
	//完工日期开始
	private String end;
	//技师名称
	private String masterName;
	//分页条件
	private PageQuery pageQuery;
	//每页记录数
	private int pageSize;
	//当前页
	private int currentPage;
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
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
