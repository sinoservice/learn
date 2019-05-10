package com.easyhome.service.oms;


import com.easyhome.vo.OrderResult;

public interface ReceiptsService {

	public OrderResult findMonthReceipts(String masterId,String completeDate);
	public OrderResult findDetail(String masterId,String workNo,String timeBegin,String timeEnd,Integer pagesize, Integer pageIndex);
	public OrderResult findWeekReceipts(String masterId, String timeBegin, String timeEnd) throws Exception;
	
}
