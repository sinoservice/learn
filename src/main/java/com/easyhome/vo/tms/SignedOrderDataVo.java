package com.easyhome.vo.tms;

import java.io.Serializable;
import java.util.List;
/**
 * 
* @ClassName: SignedOrderDataVo 
* @Description: TODO   签收单实体类
* @date 2016年11月18日 下午7:46:50 
*
 */
public class SignedOrderDataVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月18日 下午7:38:13 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private String dispatchOrderNo;// 发车单号
	private String totalOrderNum;// 订单总数
	private String needReceiptOrderNum;// 待签收/已签收/异常订单数
    List<ReceiptOrderVo> orderData;//订单信息
	public String getDispatchOrderNo() {
		return dispatchOrderNo;
	}
	public void setDispatchOrderNo(String dispatchOrderNo) {
		this.dispatchOrderNo = dispatchOrderNo;
	}
	public String getTotalOrderNum() {
		return totalOrderNum;
	}
	public void setTotalOrderNum(String totalOrderNum) {
		this.totalOrderNum = totalOrderNum;
	}
	public String getNeedReceiptOrderNum() {
		return needReceiptOrderNum;
	}
	public void setNeedReceiptOrderNum(String needReceiptOrderNum) {
		this.needReceiptOrderNum = needReceiptOrderNum;
	}
	public List<ReceiptOrderVo> getOrderData() {
		return orderData;
	}
	public void setOrderData(List<ReceiptOrderVo> orderData) {
		this.orderData = orderData;
	}    
}
