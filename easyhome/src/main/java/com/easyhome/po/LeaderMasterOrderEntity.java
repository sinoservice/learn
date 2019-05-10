package com.easyhome.po;

public class LeaderMasterOrderEntity {
	private String masterId;
	
	private String masterName;
	
	private String masterPhone;
	
	private int masterType;

	public int getMasterType() {
		return masterType;
	}

	public void setMasterType(int masterType) {
		this.masterType = masterType;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getMasterPhone() {
		return masterPhone;
	}

	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}

	@Override
	public String toString() {
		return "LeaderMasterOrderEntity [masterId=" + masterId + ", masterName=" + masterName + ", masterPhone="
				+ masterPhone + ", masterType=" + masterType + "]";
	}

	
	
	
}
