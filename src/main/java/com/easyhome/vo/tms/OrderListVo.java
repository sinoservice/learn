package com.easyhome.vo.tms;

import java.io.Serializable;
import java.util.List;

public class OrderListVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月18日 上午9:40:07 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private String currentStatusOrderNum;// 发车单下当前状态的订单数量汇总(当此字段值为0时，orderData数据为null)
	private String totalOrderNum;// 整个发车单的订单数量汇总
	List<OrderDataVo> orderList;
	public String getCurrentStatusOrderNum() {
		return currentStatusOrderNum;
	}
	public void setCurrentStatusOrderNum(String currentStatusOrderNum) {
		this.currentStatusOrderNum = currentStatusOrderNum;
	}
	public String getTotalOrderNum() {
		return totalOrderNum;
	}
	public void setTotalOrderNum(String totalOrderNum) {
		this.totalOrderNum = totalOrderNum;
	}
	public List<OrderDataVo> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderDataVo> orderList) {
		this.orderList = orderList;
	}
	
}
