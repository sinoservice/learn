package com.easyhome.vo.tms;

import java.io.Serializable;
import java.util.List;

public class OrderDetailVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月21日 上午10:29:54 
	*/ 
	
	private static final long serialVersionUID = 1L;
	
	private String customerOrderNo;// 客户订单号
	private String totalWeight;// 总重量
	private String totalQuantity;// 总数量
	private String totalVolume;// 总体积
	private String consigneeName;// 收货人
	private String consigneeTel;// 收货人电话
	private String consigneeAddress;// 收货人地址
	private String orderRemark;// 订单备注
	private String subStr1;// 备用字段1
	private String subStr2;// 备用字段1
    List<GoodsDataVo> goodsData;//商品信息
	public String getCustomerOrderNo() {
		return customerOrderNo;
	}
	public void setCustomerOrderNo(String customerOrderNo) {
		this.customerOrderNo = customerOrderNo;
	}
	public String getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
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
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
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
	public List<GoodsDataVo> getGoodsData() {
		return goodsData;
	}
	public void setGoodsData(List<GoodsDataVo> goodsData) {
		this.goodsData = goodsData;
	}
    
}
