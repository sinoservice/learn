package com.easyhome.service.oms;

public interface WorkOrderBalanceService {

//	public OrderResult findWorkOrderBalance(String driverid,String vehicleid,Integer pageindex,Integer pagesize,String startdate,String enddate);
	public String findWorkOrderBalance(String masterid,Integer pageindex,Integer pagesize,String startdate,String enddate);
}
