package com.easyhome.dao;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.WorkOrderBackup;

public interface WorkOrderBackupdao {

	public void addBackup(WorkOrderBackup workOrderBackup);
	public WorkOrderBackup findAll(@Param("workNo")String workNo);
	public void deleteBackup(@Param("workNo")String workNo);
}
