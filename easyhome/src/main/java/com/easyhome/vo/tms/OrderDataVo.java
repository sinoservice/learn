package com.easyhome.vo.tms;

import java.io.Serializable;

/**
 * 
* @ClassName: OrderDataVo 
* @Description: TODO  订单数据实体类
* @date 2016年11月17日 下午9:51:21 
*
 */
public class OrderDataVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月17日 下午9:51:16 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private String orderId;// 订单ID
	private String orderNo;// 订单号
	private String orderStatusCode;// 订单状态编码
	private String orderStatusName;// 订单状态名称
	private String customerOrderNo;// 客户订单号
	private String eajOrderNo;// 居然物联订单号
	private String consigneeName;// 收货人
	private String consigneeTel;// 电话
	private String disTotalWeight;// 运单总重量
	private String disTotalVolume;// 运单总体积
	private String orderTotalWeight;// 订单总重量
	private String orderTotalVolume;// 订单总体积
	private String consigneeAddress;// 地址
	private String addressLng;// 经度
	private String addressLat;// 纬度
	private String orderRemark;// 订单备注
	private String subStr1;// 备用字段1
	private String subStr2;// 备用字段2
	private String subStr3;// 备用字段3
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderStatusCode() {
		return orderStatusCode;
	}
	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}
	public String getOrderStatusName() {
		return orderStatusName;
	}
	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
	public String getCustomerOrderNo() {
		return customerOrderNo;
	}
	public void setCustomerOrderNo(String customerOrderNo) {
		this.customerOrderNo = customerOrderNo;
	}
	public String getEajOrderNo() {
		return eajOrderNo;
	}
	public void setEajOrderNo(String eajOrderNo) {
		this.eajOrderNo = eajOrderNo;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeTel() {
		return consigneeTel;
	}
	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}
	public String getDisTotalWeight() {
		return disTotalWeight;
	}
	public void setDisTotalWeight(String disTotalWeight) {
		this.disTotalWeight = disTotalWeight;
	}
	public String getDisTotalVolume() {
		return disTotalVolume;
	}
	public void setDisTotalVolume(String disTotalVolume) {
		this.disTotalVolume = disTotalVolume;
	}
	public String getOrderTotalWeight() {
		return orderTotalWeight;
	}
	public void setOrderTotalWeight(String orderTotalWeight) {
		this.orderTotalWeight = orderTotalWeight;
	}
	public String getOrderTotalVolume() {
		return orderTotalVolume;
	}
	public void setOrderTotalVolume(String orderTotalVolume) {
		this.orderTotalVolume = orderTotalVolume;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getAddressLng() {
		return addressLng;
	}
	public void setAddressLng(String addressLng) {
		this.addressLng = addressLng;
	}
	public String getAddressLat() {
		return addressLat;
	}
	public void setAddressLat(String addressLat) {
		this.addressLat = addressLat;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
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
}
