package com.easyhome.controller.dms;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.dms.FindStatusQueryService;


@Controller
@RequestMapping("/dms")
public class FindStatusQueryController {
	@Resource
	private FindStatusQueryService findStatusQueryService;
	/**
	 * 
	 * <@Description 查询当天所有预约成功的工单>
	 * @time 2016年10月24日 上午11:19:26
	 * @version V1.0 
	 * @param @param omsMasterId
	 * @param @param date
	 * @param @return
	 */
	@RequestMapping(value="/findStatusQuery",method=RequestMethod.POST)
	@ResponseBody
	public String FindStatusQuery(String omsMasterId,String date,String version){
		String result = findStatusQueryService.FindStatusQuery(omsMasterId, date,version);
		return result;
	}
	/**
	 * 
	 * <@Description 查询以本月所有预约成功的工单>
	 * @time 2016年10月24日 上午11:19:26
	 * @version V1.0 
	 * @param @param omsMasterId
	 * @param @param date
	 * @param @return
	 */
	@RequestMapping(value="/findMonthStatus",method=RequestMethod.POST)
	@ResponseBody
	public String findMonthStatus(String omsMasterId,String date){
		String result = findStatusQueryService.findMonthStatus(omsMasterId, date);
		return result;
	}
}
