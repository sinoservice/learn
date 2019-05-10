package com.easyhome.controller.oms;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.oms.WorkOrderBalanceService;

@RestController
@RequestMapping("/oms/balance")
public class WorkOrderBalanceController {
	/**
	 * 结算查询接口(安装)
	 */
//	@Resource
//	private WorkOrderBalanceService workOrderBalanceService;
//	@RequestMapping("/findWorkOrderBalance")
//	public OrderResult findWorkOrderBalance(String driverid,String vehicleid,Integer pageindex,Integer pagesize,String startdate,String enddate) {
//		OrderResult result=workOrderBalanceService.findWorkOrderBalance(driverid,vehicleid, pageindex, pagesize,startdate,enddate);
//		return result;
//	}
	/**
	 * 结算查询接口(配送)
	 */
	@Resource
	private WorkOrderBalanceService workOrderBalanceService;
	@RequestMapping("/findWorkOrderBalance")
	public String findWorkOrderBalance(
			String omsMasterId,
			Integer pageindex,
			Integer pagesize,
			String startdate,
			String enddate) {
		String result=workOrderBalanceService.findWorkOrderBalance(omsMasterId, pageindex, pagesize,startdate,enddate);
		return result;
	}
}
