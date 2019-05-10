package com.easyhome.controller.oms;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.oms.ReceiptsService;
import com.easyhome.vo.OrderResult;
@RestController
@RequestMapping("/oms/receipts")
public class ReceiptsController {
	@Resource
	private ReceiptsService receiptsService;
	/**
	 * 根据传入月份获取该技师该月收益金额，以及该月每周获取的收益金额。
	 * @param masterId
	 * @param completeDate
	 * @return
	 */
	@RequestMapping("/findReceipts")
	public OrderResult findMasterReceipts(String omsMasterId,String completeDate){
		OrderResult response=receiptsService.findMonthReceipts(omsMasterId, completeDate);
		return response;
	}
	/**
	 * 根据开始日期结束日期获取技师本周收益，以及该周内每天的收益。
	 * @param masterId
	 * @param weekBegin
	 * @param weekEnd
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findWeekReceipts")
	public OrderResult findWeekReceipts(String omsMasterId,String weekBegin,String weekEnd) throws Exception{
		OrderResult response=receiptsService.findWeekReceipts(omsMasterId, weekBegin, weekEnd);
		return response;
	}
	/**
	 * 根据开始时间，结束时间获取该时间段内技师完成工单收益列表
	 * @param masterId
	 * @param workNo
	 * @param timeBegin
	 * @param timeEnd
	 * @return
	 */
	@RequestMapping("/findDetail")
	public OrderResult findDetail(String omsMasterId,String workNo,String timeBegin,String timeEnd,Integer pageIndex,Integer pagesize){
		OrderResult response=receiptsService.findDetail(omsMasterId, workNo, timeBegin, timeEnd, pageIndex, pagesize);
		return response;
	}
}
