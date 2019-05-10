package com.easyhome.lbsService.po;

public class Coordinate {

	private Double lon;

	private Double lat;
	
	private int configDis=3000;

	public Coordinate() {
	}

	public Coordinate(Double lon, Double lat) {
		this.lon = lon;
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public int getConfigDis() {
		return configDis;
	}

	public void setConfigDis(int configDis) {
		this.configDis = configDis;
	}

}
