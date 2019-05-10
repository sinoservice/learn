package com.easyhome.dao;

import java.util.List;

import com.easyhome.po.WorkOrderBackup;

public interface BackupDao {
    public List<WorkOrderBackup> findWorkOrder(String workNo);
    public List<Object> findItems(String workOrderId);
}
