package com.easyhome.controller.oms;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.oms.AppGetVedioList;
import com.easyhome.service.oms.AppGetVedioListService;

/***
 * 视频查询
 * @author Gilbert.Guo
 *
 */
@Controller
@RequestMapping("/oms/user")
public class AppGetVedioListController {

	@Resource
	private AppGetVedioListService appGetVedioListService;
	
	@RequestMapping("/appGetVideoList")
	@ResponseBody
	public String appGetVedioList(AppGetVedioList request) {
		
		return appGetVedioListService.appGetVedioList(request);
	}
}
