package com.easyhome.controller.fws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DispatchInterfaceController extends BaseFwsController {

	@ResponseBody
	@RequestMapping(value="/baseInfo",method = RequestMethod.POST)
	public String findBaseData(String method, String data) {
		return baseInfoServiceI.findBaseData(method, data);
	}
	
	@ResponseBody
	@RequestMapping(value="/master",method = RequestMethod.POST)
	public String findMasterData(String method, String data) {
		return masterServiceI.findMasterData(method, data);
	}
	
	@ResponseBody
	@RequestMapping(value="/dispatch",method = RequestMethod.POST)
	public String findDispatchData(String method, String data) {
		return dispatchSerivceI.findDispatchData(method, data);
	}
	
	@ResponseBody
	@RequestMapping(value="/area",method = RequestMethod.POST)
	public String findArea(String method, String data) {
		return areaServiceI.findArea(method, data);
	}

}
