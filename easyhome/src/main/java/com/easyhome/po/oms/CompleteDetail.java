package com.easyhome.po.oms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompleteDetail {
	@JsonProperty("FID")
	private String fid;
	@JsonProperty("IMAGEURL")
	private String imageUrl;
	@JsonProperty("CHECKID")
	private String checkId;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	
}
