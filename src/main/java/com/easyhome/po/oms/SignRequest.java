package com.easyhome.po.oms;

public class SignRequest {

	private String omsMasterId;
	
	private String workorderid;//工单id
	
	private String signerid;//签到人ID
	
	private String Signer;//签到人
	
	private String type;//签到方式APP签到
	
	private String Lat;//经度
	
	private String lng;//纬度
	
	private String code;//短信验证码
	
	private  String address;//地址
	
	private String phone;//电话

	
	public String getOmsMasterId() {
		return omsMasterId;
	}

	public void setOmsMasterId(String omsMasterId) {
		this.omsMasterId = omsMasterId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public SignRequest(String workorderid, String signerid, String signer, String type, String lat, String lng,
			String code, String address) {
		super();
		this.workorderid = workorderid;
		this.signerid = signerid;
		Signer = signer;
		this.type = type;
		Lat = lat;
		this.lng = lng;
		this.code = code;
		this.address = address;
	}

	public SignRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid;
	}

	public String getSignerid() {
		return signerid;
	}

	public void setSignerid(String signerid) {
		this.signerid = signerid;
	}

	public String getSigner() {
		return Signer;
	}

	public void setSigner(String signer) {
		Signer = signer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLat() {
		return Lat;
	}

	public void setLat(String lat) {
		Lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SignRequest [workorderid=" + workorderid + ", signerid=" + signerid + ", Signer=" + Signer + ", type="
				+ type + ", Lat=" + Lat + ", lng=" + lng + ", code=" + code + ", address=" + address + ", phone="
				+ phone + "]";
	}
	
}
