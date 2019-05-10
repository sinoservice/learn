package com.easyhome.vo.tms;

import java.io.Serializable;
import java.util.List;
/**
 * 
* @ClassName: ReceiptOrderVo 
* @Description: TODO  签收单订单实体类
* @date 2016年11月18日 下午7:47:09 
*
 */
public class ReceiptOrderVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月18日 下午7:42:14 
	*/ 
	
	private static final long serialVersionUID = 1L;
	
	private String receiptOrderId;// 回单ID
	private String receiptOrderNo;// 回单号
	private String taskOrderNo;// 运输任务号
	private String orderStatusCode;// 回单状态
	private String orderStatusName;// 回单状态名称
	private String customerOrderNo;// 客户订单号
	private String eajOrderNo;// 居然物联订单号
	private String totalWeight;// 总重量
	private String totalVolume;// 总体积
	private String totalQuantity;// 总件数
	private String consigneeName;// 收货人
	private String consigneeAddress;// 地址
	private String remark;// 备注
	private String subStr1;// 备用字段1
	private String subStr2;// 备用字段1
    List<GoodsDataVo> goodsData;//商品信息
	public String getReceiptOrderId() {
		return receiptOrderId;
	}
	public void setReceiptOrderId(String receiptOrderId) {
		this.receiptOrderId = receiptOrderId;
	}
	public String getReceiptOrderNo() {
		return receiptOrderNo;
	}
	public void setReceiptOrderNo(String receiptOrderNo) {
		this.receiptOrderNo = receiptOrderNo;
	}
	public String getTaskOrderNo() {
		return taskOrderNo;
	}
	public void setTaskOrderNo(String taskOrderNo) {
		this.taskOrderNo = taskOrderNo;
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
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
