package com.easyhome.service;


import com.easyhome.vo.BaseResponse;

public interface MasterReceiptsService {

	public BaseResponse findMonthReceipts(String masterId,String completeDate);
	public BaseResponse findDetile(String masterId,String workNo,String timeBegin,String timeEnd,Integer pagesize, Integer pageIndex);
	public BaseResponse findWeekReceipts(String masterId, String timeBegin, String timeEnd) throws Exception;
}
