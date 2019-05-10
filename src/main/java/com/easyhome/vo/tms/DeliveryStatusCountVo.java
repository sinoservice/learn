package com.easyhome.vo.tms;

import java.io.Serializable;

/**
 * 
* @ClassName: DeliveryStatusCountVo 
* @Description: TODO 统计各类订单/运单数量实体类
* @date 2016年11月17日 下午7:08:48 
*
 */
public class DeliveryStatusCountVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月17日 下午7:08:44 
	*/ 
	
	private static final long serialVersionUID = 1L;
	
	private String reservedOrder;// 待预约
	private String arrivedOrder;// 待到车
	private String dispatchOrder;// 待发车
	private String signOrder;// 待签收
	private String signedOrder;// 已签收
	private String abnormalOrder;// 异常
	public String getReservedOrder() {
		return reservedOrder;
	}
	public void setReservedOrder(String reservedOrder) {
		this.reservedOrder = reservedOrder;
	}
	public String getArrivedOrder() {
		return arrivedOrder;
	}
	public void setArrivedOrder(String arrivedOrder) {
		this.arrivedOrder = arrivedOrder;
	}
	public String getDispatchOrder() {
		return dispatchOrder;
	}
	public void setDispatchOrder(String dispatchOrder) {
		this.dispatchOrder = dispatchOrder;
	}
	public String getSignOrder() {
		return signOrder;
	}
	public void setSignOrder(String signOrder) {
		this.signOrder = signOrder;
	}
	public String getSignedOrder() {
		return signedOrder;
	}
	public void setSignedOrder(String signedOrder) {
		this.signedOrder = signedOrder;
	}
	public String getAbnormalOrder() {
		return abnormalOrder;
	}
	public void setAbnormalOrder(String abnormalOrder) {
		this.abnormalOrder = abnormalOrder;
	}
}
