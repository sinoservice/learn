package com.easyhome.vo;

import java.io.Serializable;

/**
 * 
 * <p> Title: BadgeRanking</p>
 * <p> Description: 徽章排行榜</p>
 * 
 * @date 2016年5月23日 下午5:11:06
 * @version 1.0
 *
 */
public class BadgeRanking implements Serializable{

	private static final long serialVersionUID = 3638066216065044810L;
	private String masterId;
	private int sorce;
	private int orderNum;
	private int goldNum;
	private int silverNum;
	private int copperNum;
	private String organize;
	private String masterName;
	
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public int getSorce() {
		return sorce;
	}
	public void setSorce(int sorce) {
		this.sorce = sorce;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrganize() {
		return organize;
	}
	public void setOrganize(String organize) {
		this.organize = organize;
	}
	public int getGoldNum() {
		return goldNum;
	}
	public void setGoldNum(int goldNum) {
		this.goldNum = goldNum;
	}
	public int getSilverNum() {
		return silverNum;
	}
	public void setSilverNum(int silverNum) {
		this.silverNum = silverNum;
	}
	public int getCopperNum() {
		return copperNum;
	}
	public void setCopperNum(int copperNum) {
		this.copperNum = copperNum;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	
}
