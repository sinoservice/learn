package com.easyhome.service.oms;

import com.easyhome.po.oms.TamllOrderUpdate;

/**
 * 
* @ClassName: AppTamllOrderServiceI 
* @Description: TODO 喵师傅接口升级
* @date 2017年2月9日 下午5:42:24 
*
 */
public interface AppTamllOrderServiceI {

	//预约记录列表接口
	public String appBespokeDispatchRecordList(String workorderid,String masterid);
	
	//天猫单预约接口
	public String appTmallBespokeDispatch(TamllOrderUpdate orderUpdate);
	
	//预约失败二次预约时间返回接口
	public String appBespokeDispatchTwiceReservationTimeRecordList(String masterid);
	
	
}
