package com.easyhome.vo.tms;

public class DeliveryDataVo {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月17日 下午4:42:07 
	*/ 
	
	private static final long serialVersionUID = 1L;
	
	private String dispatchOrderNo;// 发车单号
	private String driverCode;// 司机编码
	private String driverPhone;// 司机手机号
	private String driverName;// 司机名称
	private String carrierCode;// 承运商编码
	private String carrierName;// 承运商名称
	private String vehicleNo;// 车牌号
	private String vehicleType;// 车型名称
	private String totalQuantity;// 总件数
	private String totalFee;// 总费用
	private String otherFee;//其他费用
	
	//=====================================
	private String totalOrderNum;// 订单数量
	private String planDepartTime;// 计划发车时间,标准格式：(YYYY-MM-DD HH:MI:SS)
	private String totalWeight;// 运单总重量
	private String totalVolume;// 运单总体积
	private String dispatchDate	;// 调度日期，标准格式：(YYYY-MM-DD HH:MI:SS)
	private String dispatchStatusCode;// 发车单状态编码
	private String dispatchStatusName;// 发车单状态名称
	
	public String getDispatchOrderNo() {
		return dispatchOrderNo;
	}
	public void setDispatchOrderNo(String dispatchOrderNo) {
		this.dispatchOrderNo = dispatchOrderNo;
	}
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
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	public String getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
	}
	public String getTotalOrderNum() {
		return totalOrderNum;
	}
	public void setTotalOrderNum(String totalOrderNum) {
		this.totalOrderNum = totalOrderNum;
	}
	public String getPlanDepartTime() {
		return planDepartTime;
	}
	public void setPlanDepartTime(String planDepartTime) {
		this.planDepartTime = planDepartTime;
	}
	public String getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}
	public String getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}
	public String getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public String getDispatchStatusCode() {
		return dispatchStatusCode;
	}
	public void setDispatchStatusCode(String dispatchStatusCode) {
		this.dispatchStatusCode = dispatchStatusCode;
	}
	public String getDispatchStatusName() {
		return dispatchStatusName;
	}
	public void setDispatchStatusName(String dispatchStatusName) {
		this.dispatchStatusName = dispatchStatusName;
	}
	
}
