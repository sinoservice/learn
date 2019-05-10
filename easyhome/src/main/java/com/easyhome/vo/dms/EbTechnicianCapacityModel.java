package com.easyhome.vo.dms;

import java.util.Date;

public class EbTechnicianCapacityModel {


	/**
	 * 技师技能中间表主键
	 */
	private Long ebtcId;
	/**
	 * 技师代码
	 */
	private String ebtcEbteCode;
	/**
	 * 商品分类代码
	 */
	private String ebtcEbmgCode;
	/**
	 * 版本号
	 */
	private Long recVer;
	/**
	 * 最后修改时间
	 */
	private Date modifyTime;
	/**
	 * 最后修改人
	 */
	private String modifier;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 状态
	 */
	private Long recStatus;
	/**
	 * 商品品类区分 0-技师、 1-工班组
	 */
	private Long capacityType;
	/**
	 * 技能等级
	 */
	private String ebtcLevel;
	public Long getEbtcId() {
		return ebtcId;
	}
	public void setEbtcId(Long ebtcId) {
		this.ebtcId = ebtcId;
	}
	public String getEbtcEbteCode() {
		return ebtcEbteCode;
	}
	public void setEbtcEbteCode(String ebtcEbteCode) {
		this.ebtcEbteCode = ebtcEbteCode;
	}
	public String getEbtcEbmgCode() {
		return ebtcEbmgCode;
	}
	public void setEbtcEbmgCode(String ebtcEbmgCode) {
		this.ebtcEbmgCode = ebtcEbmgCode;
	}
	public Long getRecVer() {
		return recVer;
	}
	public void setRecVer(Long recVer) {
		this.recVer = recVer;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Long getRecStatus() {
		return recStatus;
	}
	public void setRecStatus(Long recStatus) {
		this.recStatus = recStatus;
	}
	public Long getCapacityType() {
		return capacityType;
	}
	public void setCapacityType(Long capacityType) {
		this.capacityType = capacityType;
	}
	public String getEbtcLevel() {
		return ebtcLevel;
	}
	public void setEbtcLevel(String ebtcLevel) {
		this.ebtcLevel = ebtcLevel;
	}
	
	
}
