package com.easyhome.po.oms;

public class GetPictureRequest {
	
	public String masterId;// 技师编号
	public String type;// 照片类型（1身份证正面。2身份证反面。3银行卡）

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