package com.easyhome.service;

import com.easyhome.po.TransFormParams;
import com.easyhome.vo.BaseResponse;

public interface LeaderWorkOrderService {

	
	BaseResponse workOrders(String masterId,String type,int pageSize,int pageIndex);
	
	BaseResponse workOrderDetail(String workOrderId);
	
	BaseResponse workers(String masterId,String disPhone);
	
	BaseResponse dispatchWorkOrder(String workerId,String workOrderId,String masterId);
	
	BaseResponse giveupOrder(String workOrderId,String reason);
	
	BaseResponse workerWorkOrders(String status,String workerid,String masterid,int pagesize,int pageindex);
	//工单转派
	BaseResponse transFormWorkOrders(TransFormParams params);
	
	String dmsWorkOrders(String masterId,String type,int pageSize,int pageIndex);
	
	String dmsWorkOrderDetail(String workOrderId,String masterId);
	
	String dmsWorkers(String masterId);
	
	String dmsTransFormWorkOrders(String workOrderId, String masterId,String workerId,String workerPhone,String workerName,String workerType);
	
	String dmsQuitWorkOrder(String leaderId, String workOrderId, String remark);
}
