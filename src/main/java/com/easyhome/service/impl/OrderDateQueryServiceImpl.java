package com.easyhome.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyhome.dao.OrderDateQueryDao;
import com.easyhome.po.OrderDateQueryBean;
import com.easyhome.po.OrderDateQueryByMonth;
import com.easyhome.service.OrderDateQueryService;
import com.easyhome.utils.MonthDivide;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;

/**
 * 
 * @date 2016年11月4日 上午11:08:19
 * @Discripition
 *               <p>
 *               Company: eaju
 *               </p>
 * @version 1.0
 */
@Service
public class OrderDateQueryServiceImpl implements OrderDateQueryService {

	@Resource
	private OrderDateQueryDao orderDateQueryDao;

	@SuppressWarnings("null")
	@Override
	public BaseResponse findWorkOrderListByMonth(String masterId, String bymonth) {
		BaseResponse response = new BaseResponse();
		Map<String, Object> params = new HashMap<String, Object>();
		List<OrderDateQueryBean> result = null;

		// 格式转换
		String[] date = bymonth.split("-");
		String year = date[0];
		String month = date[1];
		String begain = "";

		// 月份
		if (month.length() != 2) {
			month = 0 + month + "/01";
			begain = year + "/" + month;

		} else if (month.length() == 2) {
			begain = year + "/" + month + "/01";

		} else {
			response.setInfo("日期格式错误");
			response.setReturnCode(ReturnCode.STATUS_404);
		}
		String end = MonthDivide.getLastDayOfMonth(bymonth);
		String replaceAll = end.replaceAll("-", "/");
		String regex = "[0-9]{4}/[0-9]{2}/[0-9]{2}";

		// 正则校验
		if (begain.matches(regex) && replaceAll.matches(regex)) {
			try {
				params.put("masterId", masterId);
				params.put("firstDay", begain);
				params.put("lastDay", replaceAll);
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new RuntimeException("parse日期异常", e1);
			}

			try {
				result = orderDateQueryDao.findWorkOrderListByMonth(params);
				List<OrderDateQueryByMonth> orderDateQueryByMonthList = new ArrayList<OrderDateQueryByMonth>();
				OrderDateQueryByMonth orderDateQueryByMonthBean;
				for (OrderDateQueryBean bookingTimeLsit : result) {// List<OrderDateQueryList>
					orderDateQueryByMonthBean = new OrderDateQueryByMonth();
					orderDateQueryByMonthBean.setBookingTime(bookingTimeLsit.getBookingTime());
					orderDateQueryByMonthList.add(orderDateQueryByMonthBean);
				}
				response.setData(orderDateQueryByMonthList);
				response.setInfo(ReturnCode.OK);
				response.setReturnCode(ReturnCode.STATUS_200);

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("按月查询预约成功工单异常", e);
			}
		}

		return response;
	}

	@Override
	public BaseResponse findWorkOrderListByDay(String masterId, String byday, String version) {
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
			Map<String, Object> params = new HashMap<String, Object>();
			String queryByDay = byday.replaceAll("-", "/");
			List<OrderDateQueryBean> result = null;
			params.put("masterId", masterId);
			// params.put("data", queryByDay);
			params.put("firstDay", queryByDay);
			params.put("lastDay", queryByDay);
			try {
				result = orderDateQueryDao.findWorkOrderListByMonth(params);
				response.setData(result);
				response.setInfo(ReturnCode.OK);
				response.setReturnCode(ReturnCode.STATUS_200);
			} catch (Exception e) {
				e.printStackTrace();
				response.setReturnCode(ReturnCode.STATUS_500);
				throw new RuntimeException("按天查询工单异常", e);
			}
			return response;
		} else {
			response.setInfo("当前版本较低,请更新版本！");
			response.setReturnCode(500);
		}
		return response;
	}

}
