package com.easyhome.po.oms;

/**
 * app技师
 * @author Martin
 *
 */
public class VisitorBean {
	
	/**
	 * 手机号
	 */
	private String phoneno;
	
	/**
	 * 登录密码
	 */
	private String password;
	
	/**
	 * 验证码
	 */
	private String authcode;
	
	/**
	 * 验证码类型 1访客注册 2修改手机号
	 */
	private String type;
	
	/**
	 * 技师主键ID
	 */
	private String masterid;
	
	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMasterid() {
		return masterid;
	}

	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}
	
}	
