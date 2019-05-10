package com.easyhome.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.OrderDateQueryService;
import com.easyhome.vo.BaseResponse;
/**
 * 
 * @date 2016年11月4日 上午11:07:55
 * @Discripition 
 * <p>Company: eaju</p>
 * @version 1.0
 */
@Controller
@RequestMapping("/orderCalendar")
public class OrderDateQueryController {

    @Resource
    private OrderDateQueryService orderDateQueryService; 
    @RequestMapping(value="/month",method=RequestMethod.GET)
    @ResponseBody
    public BaseResponse orderDateQueryByMonth(String masterId, String bymonth)
    {
     BaseResponse response =   orderDateQueryService.findWorkOrderListByMonth(masterId, bymonth);
        return response;
    }
    
    @RequestMapping(value="/day",method=RequestMethod.GET)
    @ResponseBody
    public BaseResponse orderDateQueryByDay(String masterId, String byday,String version)
    {
     BaseResponse response = orderDateQueryService.findWorkOrderListByDay(masterId, byday,version);
        return response;
    }
    
    
}
