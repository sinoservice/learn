package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.WorkOrderServiceList;
import com.easyhome.vo.BaseResponse;

@Controller
@RequestMapping("/order")      
public class WorkOrderListController {
    
    @Resource
    private WorkOrderServiceList WorkOrderServiceList;
   
    @RequestMapping(value={"/orderList"},method=RequestMethod.POST)
    @ResponseBody
    public BaseResponse findOrderList(String masterId,Integer status,Integer pageSize, Integer pageIndex,String version)
    {    
       // Gson gson  = new Gson();
       BaseResponse response = WorkOrderServiceList.findWorkOrderList(masterId, status, pageSize, pageIndex, version);
       return response;
      // return gson.toJson(response);
    }
}
