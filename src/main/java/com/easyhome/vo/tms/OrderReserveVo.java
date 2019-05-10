package com.easyhome.vo.tms;

import java.io.Serializable;

public class OrderReserveVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月21日 上午11:36:23 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private String dispatchOrderNo;// 发车单号
	private String totalOrderNum;// 订单票数
	private String neverReserveNum;// 未预约订单数
	private String reserveSuccNum;// 预约成功订单数
	private String reserveFailNum;// 预约失败订单数
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
	public String getNeverReserveNum() {
		return neverReserveNum;
	}
	public void setNeverReserveNum(String neverReserveNum) {
		this.neverReserveNum = neverReserveNum;
	}
	public String getReserveSuccNum() {
		return reserveSuccNum;
	}
	public void setReserveSuccNum(String reserveSuccNum) {
		this.reserveSuccNum = reserveSuccNum;
	}
	public String getReserveFailNum() {
		return reserveFailNum;
	}
	public void setReserveFailNum(String reserveFailNum) {
		this.reserveFailNum = reserveFailNum;
	}	
}
