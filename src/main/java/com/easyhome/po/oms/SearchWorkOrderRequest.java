package com.easyhome.po.oms;

public class SearchWorkOrderRequest {

	private String searchWords;
	
	private String omsMasterId;

	private Integer pageIndex;
	
	private Integer pagesize;

	public String getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}

	

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

	@Override
	public String toString() {
		return "SearchWorkOrderRequest [searchWords=" + searchWords + ", omsMasterId=" + omsMasterId + ", pageIndex="
				+ pageIndex + ", pagesize=" + pagesize + "]";
	}
	
	
}
