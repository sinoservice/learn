package com.easyhome.vo.tms;

import java.io.Serializable;
import java.util.List;
/**
 * 
* @ClassName: LoginVo 
* @Description: TODO 登录返回数据实体类
* @date 2016年11月16日 下午4:04:52 
*
 */
public class LoginVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月16日 下午4:04:49 
	*/ 
	
	private static final long serialVersionUID = 1L;
	private String driverCode;// 司机编码（唯一ID）
	private String driverPhone;// 司机手机号
	private String driverName;// 司机姓名
	private String subStr1;// 备用字段1
	private String subStr2;// 备用字段2
	private String subStr3;// 备用字段3
	List<ServiceAreaVo> serviceArea;
	List<VehicleInfoVo> vehicleInfo;
	public String getDriverCode() {
		return driverCode;
	}
	public void setDriverCode(String driverCode) {
		this.driverCode = driverCode;
	}
	public String getDriverPhone() {
		return driverPhone;
	}
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getSubStr1() {
		return subStr1;
	}
	public void setSubStr1(String subStr1) {
		this.subStr1 = subStr1;
	}
	public String getSubStr2() {
		return subStr2;
	}
	public void setSubStr2(String subStr2) {
		this.subStr2 = subStr2;
	}
	public String getSubStr3() {
		return subStr3;
	}
	public void setSubStr3(String subStr3) {
		this.subStr3 = subStr3;
	}
	public List<ServiceAreaVo> getServiceArea() {
		return serviceArea;
	}
	public void setServiceArea(List<ServiceAreaVo> serviceArea) {
		this.serviceArea = serviceArea;
	}
	public List<VehicleInfoVo> getVehicleInfo() {
		return vehicleInfo;
	}
	public void setVehicleInfo(List<VehicleInfoVo> vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

}
