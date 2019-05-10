package com.easyhome.po.oms;

public class RevokeWorkOrderRequest {
	private String omsMasterId;
	
	private Integer pageIndex;
	
	private Integer pagesize;


	public String getOmsMasterId() {
		return omsMasterId;
	}

	public void setOmsMasterId(String omsMasterId) {
		this.omsMasterId = omsMasterId;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	
}
