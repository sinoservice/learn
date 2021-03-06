package com.easyhome.vo.tms;

import java.io.Serializable;
import java.util.List;

public class SignOrderDetailVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月21日 下午2:29:05 
	*/ 
	
	private static final long serialVersionUID = 1L;
	private String customerOrderNo;// 客户订单号
	private String signOperType;// 签收人类型(客户,司机,工长)
	private String signType;// (01-订单签收，02-整单拒收，03-部分签收)
	private String consigneeName;// 收货人
	private String consigneeTel;// 收货人电话
	private String consigneeAddress;// 收货人地址
	private String orderRemark;// 订单备注
	private List<String> photos;// 图片
	private String subStr1;// 备用字段1
	private String subStr2;// 备用字段1
    private List<SignGoodsDataVo> signGoodsData;//签收商品详情
	public String getCustomerOrderNo() {
		return customerOrderNo;
	}
	public void setCustomerOrderNo(String customerOrderNo) {
		this.customerOrderNo = customerOrderNo;
	}
	public String getSignOperType() {
		return signOperType;
	}
	public void setSignOperType(String signOperType) {
		this.signOperType = signOperType;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
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
	public List<String> getPhotos() {
		return photos;
	}
	public void setPhotos(List<String> photos) {
		this.photos = photos;
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
	public List<SignGoodsDataVo> getSignGoodsData() {
		return signGoodsData;
	}
	public void setSignGoodsData(List<SignGoodsDataVo> signGoodsData) {
		this.signGoodsData = signGoodsData;
	}
    
}
