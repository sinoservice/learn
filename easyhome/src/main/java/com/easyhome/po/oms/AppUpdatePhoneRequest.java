package com.easyhome.po.oms;

public class AppUpdatePhoneRequest {

	private String masterid;//技师代码
	private String phoneno;//注册手机号
	private String authcode;//验证码
	public String getMasterid() {
		return masterid;
	}
	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAuthcode() {
		return authcode;
	}
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}
	@Override
	public String toString() {
		return "UpdatePhoneRequest [masterid=" + masterid + ", phoneno=" + phoneno + ", authcode=" + authcode + "]";
	}
	
}
