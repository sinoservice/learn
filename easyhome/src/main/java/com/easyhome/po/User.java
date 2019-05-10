package com.easyhome.po;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("FID")
	private String fid;//用户id
	
	@JsonProperty("NAME")
	private String name;//姓名
	
	@JsonProperty("PHONE")
	private String phone;//电话
	
	@JsonProperty("USER_TYPE")
	private int userType;//技师类型
	
	@JsonProperty("DRIVER_ID")
	private String driverId;//司机id
	
	@JsonProperty("MASTER_ID")
	private String masterId;//技师ID
	
	@JsonProperty("PLAT_FROM_ID")
	private String platFormId;//技师网点代码
	
	@JsonProperty("PLAT_FROM_NAME")
	private String platFormName;//技师网点名称
	
	@JsonProperty("IS_MODIFY_PWD")
	private String isModifyPwd;//是否更改密码
	
	@JsonProperty("WORKER_ID")
	private String workerId;
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	
	public String getPlatFormId() {
		return platFormId;
	}
	public void setPlatFormId(String platFormId) {
		this.platFormId = platFormId;
	}
	public String getPlatFormName() {
		return platFormName;
	}
	public void setPlatFormName(String platFormName) {
		this.platFormName = platFormName;
	}
	public String getIsModifyPwd() {
		return isModifyPwd;
	}
	public void setIsModifyPwd(String isModifyPwd) {
		this.isModifyPwd = isModifyPwd;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
}
