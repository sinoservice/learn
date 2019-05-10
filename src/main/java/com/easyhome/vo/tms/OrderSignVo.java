package com.easyhome.vo.tms;

import java.io.Serializable;
import java.util.List;
/**
 * 
* @ClassName: OrderSignVo 
* @Description: TODO  订单签收所需参数
* @date 2016年11月17日 下午2:22:24 
*
 */
public class OrderSignVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月17日 下午2:22:20 
	*/ 
	
	private static final long serialVersionUID = 1L;
	private String receiptOrderId;// 回单ID
	private String taskOrderNo;// 运输任务号
	private String signOperType	;// 签收人类型(客户,司机,工长)
	private String signType;// 操作类型(01-订单签收，02-整单拒收，03-部分签收)
	private String signRejectReason;// 拒收/部分签收原因（拒收或部分签收时，必填）
	private String driverCode;// 司机编码
	private String driverPhone;// 司机手机号
	private String signName;// 签收人姓名
	private String signTel;// 签收人电话
	private String signAddress;// 签收人地址
	private String signRemark;// 备注
	private String photos;// 照片（64位字节流传入，如果多张照片，按|分隔）
	List<SignGoodsDataVo> signGoodsData;
	public String getReceiptOrderId() {
		return receiptOrderId;
	}
	public void setReceiptOrderId(String receiptOrderId) {
		this.receiptOrderId = receiptOrderId;
	}
	public String getTaskOrderNo() {
		return taskOrderNo;
	}
	public void setTaskOrderNo(String taskOrderNo) {
		this.taskOrderNo = taskOrderNo;
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
	public String getSignRejectReason() {
		return signRejectReason;
	}
	public void setSignRejectReason(String signRejectReason) {
		this.signRejectReason = signRejectReason;
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
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	public String getSignTel() {
		return signTel;
	}
	public void setSignTel(String signTel) {
		this.signTel = signTel;
	}
	public String getSignAddress() {
		return signAddress;
	}
	public void setSignAddress(String signAddress) {
		this.signAddress = signAddress;
	}
	public String getSignRemark() {
		return signRemark;
	}
	public void setSignRemark(String signRemark) {
		this.signRemark = signRemark;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public List<SignGoodsDataVo> getSignGoodsData() {
		return signGoodsData;
	}
	public void setSignGoodsData(List<SignGoodsDataVo> signGoodsData) {
		this.signGoodsData = signGoodsData;
	}	
}
