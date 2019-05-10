package com.easyhome.po.oms;

public class UpdatePasswordRequest {

	private String userid;
	private String password;
	private String oldPassword;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	@Override
	public String toString() {
		return "UpdatePasswordRequest [userid=" + userid + ", password=" + password + ", oldPassword=" + oldPassword
				+ "]";
	}
	
}
