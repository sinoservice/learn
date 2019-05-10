package com.easyhome.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.dao.LeaderWorkOrderDao;
import com.easyhome.po.LeaderWorkOrderDetail;
import com.easyhome.po.LeaderWorkOrderEntity;
import com.easyhome.po.LeaderWorkOrderItemEntity;
import com.easyhome.po.LeaderWorkerEntity;
import com.easyhome.po.TransFormParams;
import com.easyhome.po.WorkOrder;
import com.easyhome.po.WorkerOrderTransform;
import com.easyhome.po.WorkerSelectEntity;
import com.easyhome.service.LeaderWorkOrderService;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

@Service("leaderWorkOrderService")
public class LeaderWorkOrderServiceImpl implements LeaderWorkOrderService {
	private Logger logger = Logger.getLogger(LeaderWorkOrderServiceImpl.class);
	@Resource
	private LeaderWorkOrderDao leaderWorkOrderDao;

	@Override
	public BaseResponse workOrders(String masterId, String type, int pageSize,
			int pageIndex) {
		BaseResponse response = new BaseResponse();
		List<LeaderWorkOrderEntity> list = new ArrayList<LeaderWorkOrderEntity>();
		try {
			int rowStart = ((pageIndex - 1) * pageSize) + 1;
			int rowEnd = pageIndex * pageSize;
			list = leaderWorkOrderDao.getNoSendWorkOrders(masterId, type,
					rowStart, rowEnd);
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo(ReturnCode.OK);
			response.setData(list);
		} catch (Exception e) {
			logger.error("获取工单数据异常", e);
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务端异常请稍后重试");
		}
		return response;
	}

	@Override
	public BaseResponse workOrderDetail(String workOrderId) {
		BaseResponse response = new BaseResponse();
		if (!Util.isEmpty(workOrderId)) {
			try {
				LeaderWorkOrderDetail workOrder = leaderWorkOrderDao
						.getWorkOrderById(workOrderId);
				if (workOrder != null) {
					List<LeaderWorkOrderItemEntity> items = leaderWorkOrderDao
							.getWorkOrderItems(workOrderId);
					workOrder.setWorkOrderItems(items);
					response.setReturnCode(ReturnCode.STATUS_200);
					response.setInfo(ReturnCode.OK);
					response.setData(workOrder);
				} else {
					response.setReturnCode(ReturnCode.STATUS_400);
					response.setInfo("无法获取工单详情");
				}
			} catch (Exception e) {
				logger.error("获取工单详情异常", e);
				response.setReturnCode(ReturnCode.STATUS_500);
				response.setInfo("服务端异常请稍后重试");
			}
		} else {
			response.setReturnCode(ReturnCode.STATUS_400);
			response.setInfo("无法获取工单详情");
		}

		return response;
	}

	@Override
	public BaseResponse workers(String masterId, String disPhone) {
		BaseResponse response = new BaseResponse();
		List<WorkerSelectEntity> list = leaderWorkOrderDao.workers(masterId);
		LeaderWorkerEntity worker = leaderWorkOrderDao.getLeader(masterId);
		if (list == null) {
			list = new ArrayList<WorkerSelectEntity>();
		}
		if (worker != null) {
			WorkerSelectEntity workerSelect = new WorkerSelectEntity();
			workerSelect.setWorkerId(worker.getWorkerId());
			workerSelect.setWorkerName(worker.getWorkerName());
			workerSelect.setWorkerPhone(worker.getWorkerPhone());
			list.add(0, workerSelect);
		}
		WorkerSelectEntity workerSelectEntity;
		for (int i = 0; i < list.size(); i++) {
			workerSelectEntity = list.get(i);
			if (!Util.isEmpty(disPhone)
					&& disPhone.equals(workerSelectEntity.getWorkerPhone())) {
				list.remove(workerSelectEntity);
			}
			workerSelectEntity.setWorkingOrderCount(leaderWorkOrderDao
					.workingCount(workerSelectEntity.getWorkerId()));
		}
		response.setReturnCode(ReturnCode.STATUS_200);
		response.setInfo(ReturnCode.OK);
		response.setData(list);
		return response;
	}

	@Override
	public BaseResponse dispatchWorkOrder(String workerId, String workOrderId,
			String masterId) {
		BaseResponse response = new BaseResponse();
		LeaderWorkerEntity worker = null;
		try {
			if (workerId != null && masterId != null
					&& workerId.equals(masterId)) {
				worker = leaderWorkOrderDao.getLeader(masterId);
			} else {
				// 获取工人信息
				worker = leaderWorkOrderDao.getWorker(workerId);
			}
			if (worker != null) {
				WorkerOrderTransform transform = new WorkerOrderTransform();
				transform.setFid(UUID.randomUUID().toString());
				transform.setWorkerId(worker.getWorkerId());
				transform.setWorkerName(worker.getWorkerName());
				transform.setWorkerPhone(worker.getWorkerPhone());
				transform.setWorkerType(worker.getWorkerType());
				transform.setWorkOrderId(workOrderId);
				transform.setTransFormDate(new Date());
				leaderWorkOrderDao.transformWorkOrder(transform);
				leaderWorkOrderDao.updateWorkOrder(workOrderId);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setInfo(ReturnCode.OK);
			} else {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("派单失败");
			}
		} catch (Exception e) {
			logger.error("派单异常", e);
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务端异常");
		}
		return response;
	}

	@Override
	public BaseResponse giveupOrder(String workOrderId, String reason) {
		BaseResponse response = new BaseResponse();
		try {
			leaderWorkOrderDao.giveupOrder(workOrderId);
			Date cancelTime = new Date();
			leaderWorkOrderDao.giveupOrderHis(workOrderId, reason, cancelTime);
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo(ReturnCode.OK);
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("放弃工单异常");
			logger.error("放弃工单异常", e);
		}
		return response;
	}

	@Override
	public BaseResponse workerWorkOrders(String status, String workerid,
			String masterid, int pagesize, int pageindex) {
		BaseResponse response = new BaseResponse();
		try {
			int rowStart = ((pageindex - 1) * pagesize) + 1;
			int rowEnd = pageindex * pagesize;
			List<WorkOrder> result = leaderWorkOrderDao.workerWorkOrders(
					status, workerid, masterid, rowStart, rowEnd);
			if (result == null) {
				result = new ArrayList<WorkOrder>();
			}
			response.setData(result);
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo(ReturnCode.OK);
		} catch (Exception e) {
			logger.error("获取工单列表失败", e);
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
		}
		return response;
	}

	@Override
	public BaseResponse transFormWorkOrders(TransFormParams params) {
		BaseResponse response = new BaseResponse();
		try {
			Date date = new Date();
			LeaderWorkerEntity leaderWorkerEntity = leaderWorkOrderDao
					.getAppUser(params.getWorkerId());
			leaderWorkOrderDao.updateTransForm(params.getWorkorderId(),
					leaderWorkerEntity.getWorkerId(),
					leaderWorkerEntity.getWorkerName(),
					leaderWorkerEntity.getWorkerPhone(),
					leaderWorkerEntity.getWorkerType(), date);
			response.setInfo(ReturnCode.OK);
			response.setReturnCode(ReturnCode.STATUS_200);
		} catch (Exception e) {
			logger.error("转单异常", e);
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务端异常");
		}

		return response;
	}

	@Override
	public String dmsTransFormWorkOrders(String workOrderId, String masterId,
			String workerId, String workerPhone, String workerName,
			String workerType) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		try {
			String basePath = Util.getProperty("tmsurl");
			Map<String, String> params = new HashMap<String, String>();
			params.put("workOrderId", workOrderId);
			params.put("leaderId", masterId);
			params.put("workerId", workerId);
			params.put("workerPhone", workerPhone);
			params.put("workerName", workerName);
			params.put("workerType", workerType);
			logger.info("～～～～～～～～～～～～～～～～～～～～～～～我了个去～～～～～～～～～～～"+params);
			String post = HttpXmlClient.post(basePath
					+ "/app/workOrder/transWorkOrder", params);
			return post;
		} catch (Exception e) {
			response.setReturnCode(500);
			response.setInfo("请求失败");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(response);

	}

	@Override
	public String dmsWorkers(String masterId) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		try {
			String basePath = Util.getProperty("tmsurl");
			Map<String, String> params = new HashMap<String, String>();
			params.put("leaderId", masterId);
			String post = HttpXmlClient.post(basePath
					+ "/app/workOrder/workers", params);
			return post;
		} catch (Exception e) {
			response.setReturnCode(500);
			response.setInfo("请求失败");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(response);
	}

	@Override
	public String dmsWorkOrderDetail(String workOrderId, String masterId) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		try {
			String basePath = Util.getProperty("tmsurl");
			Map<String, String> params = new HashMap<String, String>();
			params.put("workOrderId", workOrderId);
			params.put("leaderId", masterId);
			logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~呵呵呵呵呵呵呵俄呵呵呵呵呵呵俄呵呵！～～～～～～～～～"+params);
			String post = HttpXmlClient.post(
					basePath + "/app/workOrder/detail", params);
			return post;
		} catch (Exception e) {
			response.setReturnCode(500);
			response.setInfo("请求失败");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(response);
	}

	@Override
	public String dmsWorkOrders(String masterId, String type, int pageSize,
			int pageIndex) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		try {
			String basePath = Util.getProperty("tmsurl");
			Map<String, String> params = new HashMap<String, String>();
			params.put("leaderId", masterId);
			params.put("type", type);
			params.put("pageSize", pageSize + "");
			params.put("pageIndex", pageIndex + "");
			String post = HttpXmlClient.post(basePath+"/app/workOrder/list", params);
			return post;
		} catch (Exception e) {
			response.setReturnCode(500);
			response.setInfo("请求失败");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(response);
	}

	@Override
	public String dmsQuitWorkOrder(String leaderId, String workOrderId, String remark) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		try {
			String basePath = Util.getProperty("tmsurl");
			Map<String, String> params = new HashMap<String, String>();
			params.put("leaderId", leaderId);
			params.put("workOrderId",workOrderId);
			params.put("remark",remark);
			String post = HttpXmlClient.post(basePath+"/app/workOrder/quit", params);
			return post;
		} catch (Exception e) {
			response.setReturnCode(500);
			response.setInfo("请求失败");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(response);
	}
}
