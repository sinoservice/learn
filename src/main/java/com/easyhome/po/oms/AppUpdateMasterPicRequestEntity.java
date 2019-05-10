package com.easyhome.po.oms;

import java.io.Serializable;

public class AppUpdateMasterPicRequestEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String masterId;// 技师编码
	private String image1;// 身份证正面照片
	private String image2;// 身份证反面照片
	private String image3;// 头像照片

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

}
