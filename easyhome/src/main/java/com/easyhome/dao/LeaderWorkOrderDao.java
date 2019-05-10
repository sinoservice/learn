package com.easyhome.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.LeaderWorkOrderDetail;
import com.easyhome.po.LeaderWorkOrderEntity;
import com.easyhome.po.LeaderWorkOrderItemEntity;
import com.easyhome.po.LeaderWorkerEntity;
import com.easyhome.po.WorkOrder;
import com.easyhome.po.WorkerOrderTransform;
import com.easyhome.po.WorkerSelectEntity;

public interface LeaderWorkOrderDao {

	List<LeaderWorkOrderEntity> getNoSendWorkOrders(
			@Param("masterId") String masterId, @Param("type") String type,
			@Param("rowStart") int rowStart, @Param("rowEnd") int rowEnd);

	LeaderWorkOrderDetail getWorkOrderById(
			@Param("workOrderId") String workOrderId);

	List<LeaderWorkOrderItemEntity> getWorkOrderItems(
			@Param("workOrderId") String workOrderId);

	List<WorkerSelectEntity> workers(@Param("masterId") String masterId);
	
	int workingCount(@Param("masterId") String masterId);

	LeaderWorkerEntity getWorker(@Param("workerId") String workerId);

	void transformWorkOrder(WorkerOrderTransform transform);

	LeaderWorkerEntity getLeader(@Param("masterId") String masterId);

	int updateWorkOrder(@Param("workOrderId") String workOrderId);

	int giveupOrder(@Param("workOrderId") String workOrderId);

	int giveupOrderHis(@Param("workOrderId") String workOrderId,
			@Param("reason") String reason, @Param("cancelTime") Date cancelTime);
	
	List<WorkOrder> workerWorkOrders(@Param("status")String status,@Param("workerId")String workerId, @Param("masterId")String masterId,
			@Param("rowStart")int rowStart, @Param("rowEnd")int rowEnd);
	

	int updateTransForm( @Param("workorderId")String workorderId,@Param("workerId")String workerId,@Param("name")String name,
			@Param("phone")String phone,@Param("workertype")String workertype,@Param("date")Date date);

	LeaderWorkerEntity getAppUser(@Param("masterId") String masterId);
}
