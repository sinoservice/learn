package com.easyhome.service;

import com.easyhome.vo.BaseResponse;
/**
 * 
 * @date 2016年11月4日 上午11:08:50
 * @Discripition 
 * <p>Company: eaju</p>
 * @version 1.0
 */
public interface OrderDateQueryService {
    BaseResponse  findWorkOrderListByMonth(String masterId,String bymonth);
    BaseResponse  findWorkOrderListByDay(String masterId,String byday,String version);
}
