package com.easyhome.po.oms;

import java.io.Serializable;

public class AppObtainDispatchOrderRequestEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String workNo;// 派工单号
	private String masterId;// 技师编号
	private String type;// 类型：1、抢单；2、取消抢单
	
	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	  
}
