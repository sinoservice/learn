package com.easyhome.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p> Title: SatisfiedByWokeOrderCustom</p>
 * <p> Description: 工单维度的完工满意度报表自定义类</p>
 * 
 * @date 2016年5月25日 下午3:58:23
 * @version 1.0
 *
 */
public class SatisfiedByWokeOrderCustom implements Serializable{

	private static final long serialVersionUID = -8874527247012797572L;
	//工单号
	private String workNo;
	//工单类型，安装、运输，拆旧等
	private String type;
	//调度平台
	private String platform;
	//省份
	private String province;
	//客户姓名
	private String cusName;
	//客户电话
	private String cusTel;
	//客户地址
	private String cusAddress;
	//完工日期
	private Date completeDate;
	//技师名称
	private String masterName;
	//技师ID
	private String masterId;
	//技师电话
	private String masterPhone;
	//时效
	private int timely;
	//态度
	private int attitude;
	//技能
	private int skill;
	//时效百分比
	private String timelySatisfied;
	//态度百分比
	private String attitudeSatisfied;
	//技能百分比
	private String skillSatisfied;
	//综合分数
	private int comprehensive;
	//综合分百分比
	private String comprehensivePercent;
	
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusTel() {
		return cusTel;
	}
	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getMasterPhone() {
		return masterPhone;
	}
	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}
	public int getTimely() {
		return timely;
	}
	public void setTimely(int timely) {
		this.timely = timely;
	}
	public int getAttitude() {
		return attitude;
	}
	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	public String getTimelySatisfied() {
		return timelySatisfied;
	}
	public void setTimelySatisfied(String timelySatisfied) {
		this.timelySatisfied = timelySatisfied;
	}
	public String getAttitudeSatisfied() {
		return attitudeSatisfied;
	}
	public void setAttitudeSatisfied(String attitudeSatisfied) {
		this.attitudeSatisfied = attitudeSatisfied;
	}
	public String getSkillSatisfied() {
		return skillSatisfied;
	}
	public void setSkillSatisfied(String skillSatisfied) {
		this.skillSatisfied = skillSatisfied;
	}
	public int getComprehensive() {
		return comprehensive;
	}
	public void setComprehensive(int comprehensive) {
		this.comprehensive = comprehensive;
	}
	public String getComprehensivePercent() {
		return comprehensivePercent;
	}
	public void setComprehensivePercent(String comprehensivePercent) {
		this.comprehensivePercent = comprehensivePercent;
	}
	
}
