package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.MasterReceiptsService;
import com.easyhome.vo.BaseResponse;
@RestController
@RequestMapping("/receipts")
public class MasterReceiptsController {
	@Resource
	private MasterReceiptsService masterReceiptsService;
	/**
	 * 根据传入月份获取该技师该月收益金额，以及该月每周获取的收益金额。
	 * @param masterId
	 * @param completeDate
	 * @return
	 */
	@RequestMapping("/findReceipts")
	public BaseResponse findMasterReceipts(String masterId,String completeDate){
		BaseResponse response=masterReceiptsService.findMonthReceipts(masterId, completeDate);
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
	public BaseResponse findWeekReceipts(String masterId,String weekBegin,String weekEnd) throws Exception{
		BaseResponse response=masterReceiptsService.findWeekReceipts(masterId, weekBegin, weekEnd);
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
	public BaseResponse findDetail(String masterId,String workNo,String timeBegin,String timeEnd,Integer pageIndex,Integer pagesize){
		BaseResponse response=masterReceiptsService.findDetile(masterId, workNo, timeBegin, timeEnd, pageIndex, pagesize);
		return response;
	}
}
