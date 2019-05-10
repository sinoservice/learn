package com.easyhome.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.easyhome.dao.WorkOrderListDao;
import com.easyhome.po.WorkOrderList;
import com.easyhome.service.WorkOrderServiceList;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;

/**
 * 
 * @date 2016年11月9日 下午1:51:52
 * @Discripition 老APP后台工单列表查询添加预约失败列表查询功能
 *               <p>
 *               Company: eaju
 *               </p>
 * @version 1.0
 */
@Service
public class WorkOrderServiceListImpl implements WorkOrderServiceList {
	@Resource
	private WorkOrderListDao workOrderListDao;

	@Override
	public BaseResponse findWorkOrderList(String masterId, Integer status, Integer pageSize, Integer pageIndex,
			String version) {
		BaseResponse response = new BaseResponse();
		String newestVersion = ResourcesUtil.getValue("config", "newestVersion");
		Double versionNow = Double.parseDouble(newestVersion);// 当前版本号
		Double versionPass=0.0;
		if(version == null || "".equals(version)){
			response.setInfo("当前版本较低,请更新版本！");
			response.setReturnCode(500);
		}else{
			 versionPass = Double.parseDouble(version);//传入版本号
		}
		if (versionPass >= versionNow) {
			List<WorkOrderList> result = null;
			if (StringUtils.isBlank(masterId) || status == null || pageSize == null || pageIndex == null) {
				response.setInfo(ReturnCode.NO_DATA);
				response.setReturnCode(ReturnCode.STATUS_403);
				result = new ArrayList<WorkOrderList>();
				response.setData(result);

				return response;
			}
			int rowStart = ((pageIndex - 1) * pageSize) + 1;
			int rowEnd = pageIndex * pageSize;

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("masterId", masterId);
			params.put("rowStart", rowStart);
			params.put("rowEnd", rowEnd);

			// ========================1待预约
			try {

				if (1 == status) {
					params.put("statusDisplay", "待预约");
					result = workOrderListDao.findWorkOrderList(params);
					response.setData(result);
					response.setInfo("查询待预约接口成功");
					response.setReturnCode(ReturnCode.STATUS_200);
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.setReturnCode(ReturnCode.STATUS_500);
				response.setInfo("获取待预约接口异常");
				result = new ArrayList<WorkOrderList>();
				response.setData(result);
			}

			// ======================2预约失败
			try {

				if (2 == status) {
					params.put("statusDisplay", "预约失败");
					result = workOrderListDao.findWorkOrderList(params);
					response.setData(result);
					response.setInfo("查询预约失败接口成功");
					response.setReturnCode(ReturnCode.STATUS_200);
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.setReturnCode(ReturnCode.STATUS_500);
				response.setInfo("获取待预约失败接口异常");
				result = new ArrayList<WorkOrderList>();
				response.setData(result);
			}

			// ============================3待服务
			try {

				if (3 == status) {
					params.put("statusDisplay", "待服务");
					params.put("statusDisplay1", "服务中");
					result = workOrderListDao.findWorkOrderList(params);
					response.setData(result);
					response.setInfo("查询待服务接口成功");
					response.setReturnCode(ReturnCode.STATUS_200);
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.setReturnCode(ReturnCode.STATUS_500);
				response.setInfo("获取待服务接口异常");
				result = new ArrayList<WorkOrderList>();
				response.setData(result);
			}

			// ============================4 已完工、待结算 、已回访 、已结算
			try {

				if (4 == status) {
					params.put("statusDisplay", "已完工");
					params.put("statusDisplay2", "待结算");
					params.put("statusDisplay3", "已回访");
					params.put("statusDisplay4", "已结算");
					result = workOrderListDao.findWorkOrderList(params);
					response.setData(result);
					response.setInfo("查询已完工接口成功");
					response.setReturnCode(ReturnCode.STATUS_200);
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.setReturnCode(ReturnCode.STATUS_500);
				response.setInfo("获取已完工接口异常");
				result = new ArrayList<WorkOrderList>();
				response.setData(result);
			}
			return response;
		} else {
			response.setInfo("当前版本较低,请更新版本！");
			response.setReturnCode(500);
		}
		return response;
	}
}
