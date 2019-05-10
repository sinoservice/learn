package com.easyhome.po;

import java.util.Date;

public class Kilometer {

	private String fid;//主键
	
	private String driverNo;//运单号
	
	private String driverId;//司机id
	
	private double startKilometer;//开始公里数
	
	private String startUrl;//开始图片
	
	private Date createTime;//开始时间
	
	private double endKilometer;//结束公里数
	
	private String endUrl;//结束图片
	
	private Date endTime;//结束时间

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getDriverNo() {
		return driverNo;
	}

	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public double getStartKilometer() {
		return startKilometer;
	}

	public void setStartKilometer(double startKilometer) {
		this.startKilometer = startKilometer;
	}

	public String getStartUrl() {
		return startUrl;
	}

	public void setStartUrl(String startUrl) {
		this.startUrl = startUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getEndKilometer() {
		return endKilometer;
	}

	public void setEndKilometer(double endKilometer) {
		this.endKilometer = endKilometer;
	}

	public String getEndUrl() {
		return endUrl;
	}

	public void setEndUrl(String endUrl) {
		this.endUrl = endUrl;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
	
}
