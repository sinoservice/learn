package com.easyhome.dao;

import java.util.List;
import java.util.Map;

import com.easyhome.po.WorkOrderList;

public interface WorkOrderListDao {
    List<WorkOrderList> findWorkOrderList(Map<String,Object> params);
}
