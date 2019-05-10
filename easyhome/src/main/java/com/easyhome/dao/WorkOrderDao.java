package com.easyhome.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.WorkOrder;

public interface WorkOrderDao {

	List<WorkOrder> findWorkOrder(
			@Param("workNoOrcusTel") String workNoOrcusTel,
			@Param("masterId") String masterId,
			@Param("rowStart") Integer rowStart,
			@Param("rowEnd") Integer rowEnd);
}