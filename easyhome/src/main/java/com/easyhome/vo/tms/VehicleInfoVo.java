package com.easyhome.vo.tms;

import java.io.Serializable;
/**
 * 
* @ClassName: VehicleInfoVo 
* @Description: TODO  车辆信息实体类
* @date 2016年11月16日 下午4:01:55 
*
 */
public class VehicleInfoVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月16日 下午4:01:19 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private String vehicleNo;// 车牌号	
	private String vehicleNoColor;// 车牌颜色	
	private String vehicleType;// 车型	
	private String maxLoadWeight;// 核定装载重量	
	private String maxLoadVolume;// 核定装载体积	
	private String carrierCode;// 承运商编码	
	private String carrierName;// 承运商名称	
	private String vehicleStatus;// 车辆状态	
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleNoColor() {
		return vehicleNoColor;
	}
	public void setVehicleNoColor(String vehicleNoColor) {
		this.vehicleNoColor = vehicleNoColor;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getMaxLoadWeight() {
		return maxLoadWeight;
	}
	public void setMaxLoadWeight(String maxLoadWeight) {
		this.maxLoadWeight = maxLoadWeight;
	}
	public String getMaxLoadVolume() {
		return maxLoadVolume;
	}
	public void setMaxLoadVolume(String maxLoadVolume) {
		this.maxLoadVolume = maxLoadVolume;
	}
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

}
