package com.easyhome.po.oms;

public class AppointmentRequest {

	public AppointmentRequest() {
		// TODO Auto-generated constructor stub
	}
	
	private String omsMasterId;
	
	private String workorderid;//工单ID
	
	private String linkman;//安装联系人
	
	private String address;//安装联系人地址
	
	private String phone;//安装联系人电话
	
	private int status;// 预约状态：失败-0 成功-1
	
	private String reason;//预约失败原因
	
	private String date;//预约日期
	
	private String call;//是否拨打了电话
	
	private String timeQuantum;//预约时间段

	
	public String getOmsMasterId() {
		return omsMasterId;
	}

	public void setOmsMasterId(String omsMasterId) {
		this.omsMasterId = omsMasterId;
	}

	public String getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public String getTimeQuantum() {
		return timeQuantum;
	}

	public void setTimeQuantum(String timeQuantum) {
		this.timeQuantum = timeQuantum;
	}

	@Override
	public String toString() {
		return "AppointmentRequest [omsMasterId=" + omsMasterId + ", workorderid=" + workorderid + ", linkman="
				+ linkman + ", address=" + address + ", phone=" + phone + ", status=" + status + ", reason=" + reason
				+ ", date=" + date + ", call=" + call + ", timeQuantum=" + timeQuantum + "]";
	}

	public AppointmentRequest(String omsMasterId, String workorderid, String linkman, String address, String phone,
			int status, String reason, String date, String call, String timeQuantum) {
		super();
		this.omsMasterId = omsMasterId;
		this.workorderid = workorderid;
		this.linkman = linkman;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.reason = reason;
		this.date = date;
		this.call = call;
		this.timeQuantum = timeQuantum;
	}
	
}
