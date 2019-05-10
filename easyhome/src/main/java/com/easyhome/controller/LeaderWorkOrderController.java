package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.LeaderWorkOrderService;
import com.easyhome.vo.BaseResponse;

@RestController
@RequestMapping("/leader")
public class LeaderWorkOrderController {
	@Resource
	private LeaderWorkOrderService leaderWorkOrderService;
    //根据工长id/类型查询工单列表
	@RequestMapping("/workOrders")
	public String workOrderList(String masterId, String type,
			int pageSize, int pageIndex) {
		//return leaderWorkOrderService.workOrders(masterId, type, pageSize,pageIndex);
		return leaderWorkOrderService.dmsWorkOrders(masterId, type, pageSize, pageIndex);
	}

	//根据工单ID和工长id查看工单详情
	@RequestMapping("/workOrderDetail")
	public String workOrderDetail(String workOrderId,String masterId) {
		//return leaderWorkOrderService.workOrderDetail(workOrderId);
		return leaderWorkOrderService.dmsWorkOrderDetail(workOrderId,masterId);
	}

	//工长派单查询技师手下工人列表
	@RequestMapping("/workers")
	public String workerList(String masterId,String disPhone) {
		//return leaderWorkOrderService.workers(masterId,disPhone);
		return leaderWorkOrderService.dmsWorkers(masterId);
	}

	@RequestMapping("/dispatchOrder")
	public BaseResponse dispatchWorkOrder(String workerId, String workOrderId,
			String masterId) {
		return leaderWorkOrderService.dispatchWorkOrder(workerId, workOrderId,
				masterId);
	}

	@RequestMapping("/giveupOrder")
	public BaseResponse giveUpWordOrderId(String workOrderId, String reason) {
		return leaderWorkOrderService.giveupOrder(workOrderId, reason);
	}
	
	@RequestMapping("/workerWorkOrders")
	public BaseResponse workerWorkOrders(String status,String workerid,String masterid,int pagesize,int pageindex){
		return leaderWorkOrderService.workerWorkOrders(status,workerid, masterid, pagesize, pageindex);
	}
	//工长派单给工人
	@RequestMapping("/transForm")
	public String transFormWorkerOrders(String workOrderId, String masterId,String workerId, String workerPhone, String workerName,String workerType){
		//return leaderWorkOrderService.transFormWorkOrders(params);
		return leaderWorkOrderService.dmsTransFormWorkOrders(workOrderId, masterId, workerId, workerPhone, workerName, workerType);		
	}
	
	@RequestMapping("/quit")
	public String quitWorkOrder(String leaderId, String workOrderId, String remark){
		return leaderWorkOrderService.dmsQuitWorkOrder(leaderId, workOrderId, remark);
	}
}
