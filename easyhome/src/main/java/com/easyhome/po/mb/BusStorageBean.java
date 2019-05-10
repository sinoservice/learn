package com.easyhome.po.mb;

import java.io.Serializable;

public class BusStorageBean implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月18日 下午3:32:20 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private String busId;//业务主键
	private String img;//图片路径
    private String busSequence;//商品序列号 
	private int busType;//商家类型
	
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBusSequence() {
		return busSequence;
	}
	public void setBusSequence(String busSequence) {
		this.busSequence = busSequence;
	}
	public int getBusType() {
		return busType;
	}
	public void setBusType(int busType) {
		this.busType = busType;
	}
		
}
