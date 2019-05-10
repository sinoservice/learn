package com.easyhome.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.dao.MasterReceiptsDao;
import com.easyhome.po.MasterReceipts;
import com.easyhome.po.ReceiptsDetial;
import com.easyhome.po.Week;
import com.easyhome.service.MasterReceiptsService;
import com.easyhome.utils.MonthDivide;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.MonthDivide.FindDates;
import com.easyhome.vo.BaseResponse;

@Service("masterReceiptsService")
public class MasterReceiptsServiceImpl implements MasterReceiptsService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MasterReceiptsServiceImpl.class);
	/**
	 * 查询每月的总收益
	 * @param masterId
	 * @param completeDate
	 */
	@Resource
	private MasterReceiptsDao masterReceiptsDao;
	
	public BaseResponse findMonthReceipts(String masterId,String completeDate) {
		BaseResponse response=new BaseResponse();
		Map<String,Object> data=new HashMap<String,Object>();
		String firstDay=completeDate+"-01";
		String lastDay = MonthDivide.getLastDayOfMonth(completeDate);
		String regex="[0-9]{4}-[0-9]{2}-[0-9]{2}";
			if(firstDay.matches(regex) && lastDay.matches(regex)){
			try {
			
			Double receipts=masterReceiptsDao.findReceipts(masterId, firstDay, lastDay);
			data.put("month_profit", receipts);
			
			/**
			 * 查询每月每周所有收益
			 * @param masterId
			 * @param completeDate 前台参数 2016-05
			 */
			
			List<Week> weekList = new ArrayList<Week>();
			Week detile= null;
				List<Week> listWeek = MonthDivide.getDays(completeDate);
				int weekSize = 0;
					weekSize = listWeek.size();
					// 找到当月有多少个周 
					for(int i = 0; i < weekSize; i++){
						Week week = listWeek.get(i);
						String weekBegin = week.getWeekBegin();
						String weekEnd = week.getWeekEnd();
						detile=masterReceiptsDao.findWeekById(masterId, weekBegin, weekEnd);
						detile.setWeekBegin(weekBegin);
						detile.setWeekEnd(weekEnd);
						weekList.add(detile);
					}
					data.put("weeks_profit", weekList);
			
			/**
			 * 查询所有收益（已完工）
			 * @param masterid
			 * @param completeDate
			 */
				Double allReceipts=masterReceiptsDao.findReceiptsById(masterId);
				data.put("all_profit", allReceipts);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setInfo(ReturnCode.OK);
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_404);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据库连接失败！",e);
		}
			}else{
				response.setReturnCode(ReturnCode.STATUS_404);
				response.setInfo("您输入的日期格式有误,请重新输入！");
				logger.error("日期输入格式有误！");
			}
			response.setData(data);
			return response;
		
}	
	/**
	 *通过开始日期结束日期获取技师本周收益，以及该周每天的收益
	 * @throws Exception 
	 */
	
	
	public BaseResponse findWeekReceipts(String masterId,String weekBegin,String weekEnd) throws Exception {
		BaseResponse response=new BaseResponse();
		Map<String,Object> data=new HashMap<>();
		String regex="[0-9]{4}-[0-9]{2}-[0-9]{2}";
		try {
			if(weekBegin.matches(regex) && weekEnd.matches(regex)){
			//查询本周收益
			Double receipts=masterReceiptsDao.findWeekReceipts(masterId,weekBegin, weekEnd);
			data.put("week_profit", receipts);
			
			/**
			 * 查询所有收益（已完工）
			 * @param masterid
			 * @param completeDate
			 */
			
				Double allReceipts=masterReceiptsDao.findReceiptsById(masterId);
				data.put("all_profit", allReceipts);
				
			//查询每周收益
			List<MasterReceipts> weekList=new ArrayList<MasterReceipts>();
			MasterReceipts profit=null;
			//获取每周开始，结束时间
			 Calendar cal = Calendar.getInstance();  
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			    
			    Date dBegin = sdf.parse(weekBegin);  
			    Date dEnd = sdf.parse(weekEnd);  
			    List<Date> lDate =FindDates.findDates(dBegin, dEnd); 
			    //遍历每一天
			    for (Date date : lDate) {  
			        String weekDay=sdf.format(date); 
			        profit=masterReceiptsDao.findDayReceipts(masterId, weekDay);
			        profit.setDay(weekDay);
			        weekList.add(profit);
			    }  
			    data.put("datys_profit", weekList);
			    response.setReturnCode(ReturnCode.STATUS_200);
			    response.setInfo(ReturnCode.OK);
			}else{
				response.setReturnCode(ReturnCode.STATUS_404);
				response.setInfo("您输入的日期格式有误,请重新输入！");
				logger.error("日期输入格式有误！");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_404);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据库连接失败！",e);
		}
		response.setData(data);
		return response;
	}
	/**
	 * 根据指定日期获取时间段内每天的收益
	 */

	public BaseResponse findDetile(String masterId, String workNo, String timeBegin, String timeEnd, Integer pageIndex,Integer pagesize) {
		BaseResponse response=new BaseResponse();
		Map<String,Object> map=new HashMap<>();
		List<ReceiptsDetial> detile=new ArrayList<>();
		try {
			int rowStart = ((pageIndex - 1) * pagesize) + 1;
			int rowEnd = pageIndex * pagesize;
			String regex="[0-9]{4}-[0-9]{2}-[0-9]{2}";
		if(timeBegin.matches(regex) && timeEnd.matches(regex)){
			detile = masterReceiptsDao.findDetail(masterId, timeBegin, timeEnd,rowStart, rowEnd);
			map.put("order_profit", detile);
			 response.setReturnCode(ReturnCode.STATUS_200);
			 response.setInfo(ReturnCode.OK);
		}else{
			response.setReturnCode(ReturnCode.STATUS_404);
			response.setInfo("您输入的日期格式有误,请重新输入！");
			logger.error("日期输入格式有误！");
		}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_404);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("获取数据异常！",e);
		}
		response.setData(map);
		return response;
	}
	
}
