package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.AppGetRewardAndPunish;
import com.easyhome.service.AppGetRewardAndPunishService;

/***
 * 奖惩规则
 * @author Gilbert.Guo
 *
 */
@Controller
@RequestMapping("/oms/user")
public class AppGetRewardAndPunishController {

	@Resource
	private AppGetRewardAndPunishService appGetRewardAndPunishService;
	
	@RequestMapping("/appGetRewardAndPunish")
	@ResponseBody
	public String appGetRewardAndPunish(AppGetRewardAndPunish request) {
		
		return appGetRewardAndPunishService.appGetRewardAndPunish(request);
	}
}
