package com.easyhome.po.oms;

public class FindWorkOrderRequest {

	private String omsMasterId;
	
	private Integer pageindex;
	
	private Integer pagesize;
	
	private String status;

	public String getOmsMasterId() {
		return omsMasterId;
	}

	public void setOmsMasterId(String omsMasterId) {
		this.omsMasterId = omsMasterId;
	}

	public Integer getPageindex() {
		return pageindex;
	}

	public void setPageindex(Integer pageindex) {
		this.pageindex = pageindex;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
