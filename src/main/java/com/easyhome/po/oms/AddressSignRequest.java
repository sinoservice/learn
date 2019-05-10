package com.easyhome.po.oms;

public class AddressSignRequest {
	
	private Double lat;//纬度
	
	private Double lon;//经度
	
	private Integer configDis;//距离
	
	private String address;//地址

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Integer getConfigDis() {
		return configDis;
	}

	public void setConfigDis(Integer configDis) {
		this.configDis = configDis;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AddressSignRequest(Double lat, Double lon, Integer configDis, String address) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.configDis = configDis;
		this.address = address;
	}

	public AddressSignRequest() {
	
	}
	
	
	
}
