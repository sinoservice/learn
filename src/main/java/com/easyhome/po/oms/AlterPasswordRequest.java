package com.easyhome.po.oms;

public class AlterPasswordRequest {

	private String phone;
	
	private String password;
	
	private String code;

	/***
	 * 0是没有密码的，1是有密码的
	 */
	private String isPassword;
	
	public String getIsPassword() {
		return isPassword;
	}

	public void setIsPassword(String isPassword) {
		this.isPassword = isPassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
