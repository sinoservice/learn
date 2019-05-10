package com.easyhome.vo;

/**
 * 
 * <p> Title: TbWorkOrderCustom</p>
 * <p> Description: 技师徽章实体</p>
 * 
 * @date 2016年5月23日 下午3:10:27
 * @version 1.0
 *
 */
public class MasterBadge {
	
	private String masterId;
	private int goldMedal;
	private int silverMedal;
	private int copperMedal;
	
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public int getGoldMedal() {
		return goldMedal;
	}
	public void setGoldMedal(int goldMedal) {
		this.goldMedal = goldMedal;
	}
	public int getSilverMedal() {
		return silverMedal;
	}
	public void setSilverMedal(int silverMedal) {
		this.silverMedal = silverMedal;
	}
	public int getCopperMedal() {
		return copperMedal;
	}
	public void setCopperMedal(int copperMedal) {
		this.copperMedal = copperMedal;
	}
	
	
	
}
