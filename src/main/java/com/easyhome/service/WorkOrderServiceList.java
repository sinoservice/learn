package com.easyhome.service;

import com.easyhome.vo.BaseResponse;

public interface WorkOrderServiceList {
      public BaseResponse findWorkOrderList(String masterId,Integer status,Integer pageSize,Integer pageIndex,String version);
}
