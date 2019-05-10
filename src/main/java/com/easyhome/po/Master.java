package com.easyhome.po;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Master {
	@JsonProperty("FID")
	private String fid;//用户id
	
	@JsonProperty("NAME")
	private String name;//姓名
	
	@JsonProperty("PHONE")
	private String phone;//电话
	
	@JsonProperty("PLAT_FORM_ID")
	private String platFormId;//技师网点代码
	
	@JsonProperty("PLAT_FORM_NAME")
	private String platFormName;//技师网点名称
	
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
	
	
}



