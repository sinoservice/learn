package com.easyhome.vo;

import java.io.Serializable;
/**
 * 
 * <p> Title: SatisfiedByMasterCustom</p>
 * <p> Description: 技师满意度报表</p>
 * 
 * @date 2016年5月27日 下午3:28:06
 * @version 1.0
 *
 */
public class SatisfiedByMasterCustom implements Serializable{

	private static final long serialVersionUID = 6915633108124180264L;
	
	//技师ID
	private String masterId;
	//调度平台
	private String organize;
	//省份
	private String province;
	//技师姓名
	private String name;
	//技师电话
	private String phone;
	
	private int timely5;
	private int timely4;
	private int timely3;
	private int timely2;
	private int timely1;
	private int timely0;
	
	private int attitude5;
	private int attitude4;
	private int attitude3;
	private int attitude2;
	private int attitude1;
	private int attitude0;
	
	private int skill5;
	private int skill4;
	private int skill3;
	private int skill2;
	private int skill1;
	private int skill0;
	
	//总单量
	private int total;
	//有效单量
	private int effective;
	
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getOrganize() {
		return organize;
	}
	public void setOrganize(String organize) {
		this.organize = organize;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTimely5() {
		return timely5;
	}
	public void setTimely5(int timely5) {
		this.timely5 = timely5;
	}
	public int getTimely4() {
		return timely4;
	}
	public void setTimely4(int timely4) {
		this.timely4 = timely4;
	}
	public int getTimely3() {
		return timely3;
	}
	public void setTimely3(int timely3) {
		this.timely3 = timely3;
	}
	public int getTimely2() {
		return timely2;
	}
	public void setTimely2(int timely2) {
		this.timely2 = timely2;
	}
	public int getTimely1() {
		return timely1;
	}
	public void setTimely1(int timely1) {
		this.timely1 = timely1;
	}
	public int getTimely0() {
		return timely0;
	}
	public void setTimely0(int timely0) {
		this.timely0 = timely0;
	}
	public int getAttitude5() {
		return attitude5;
	}
	public void setAttitude5(int attitude5) {
		this.attitude5 = attitude5;
	}
	public int getAttitude4() {
		return attitude4;
	}
	public void setAttitude4(int attitude4) {
		this.attitude4 = attitude4;
	}
	public int getAttitude3() {
		return attitude3;
	}
	public void setAttitude3(int attitude3) {
		this.attitude3 = attitude3;
	}
	public int getAttitude2() {
		return attitude2;
	}
	public void setAttitude2(int attitude2) {
		this.attitude2 = attitude2;
	}
	public int getAttitude1() {
		return attitude1;
	}
	public void setAttitude1(int attitude1) {
		this.attitude1 = attitude1;
	}
	public int getAttitude0() {
		return attitude0;
	}
	public void setAttitude0(int attitude0) {
		this.attitude0 = attitude0;
	}
	public int getSkill5() {
		return skill5;
	}
	public void setSkill5(int skill5) {
		this.skill5 = skill5;
	}
	public int getSkill4() {
		return skill4;
	}
	public void setSkill4(int skill4) {
		this.skill4 = skill4;
	}
	public int getSkill3() {
		return skill3;
	}
	public void setSkill3(int skill3) {
		this.skill3 = skill3;
	}
	public int getSkill2() {
		return skill2;
	}
	public void setSkill2(int skill2) {
		this.skill2 = skill2;
	}
	public int getSkill1() {
		return skill1;
	}
	public void setSkill1(int skill1) {
		this.skill1 = skill1;
	}
	public int getSkill0() {
		return skill0;
	}
	public void setSkill0(int skill0) {
		this.skill0 = skill0;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getEffective() {
		return effective;
	}
	public void setEffective(int effective) {
		this.effective = effective;
	}

}
