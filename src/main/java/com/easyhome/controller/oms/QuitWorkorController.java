package com.easyhome.controller.oms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.oms.QuitWorkorService;

@Controller
@RequestMapping("/oms/workOrder")
public class QuitWorkorController {

	@Autowired
	private QuitWorkorService quitWorkorService;
	
	/**
	 * 
	 * <p> Description: 放弃工单</p>
	 * 
	 * @date 2016年7月6日 下午5:22:21
	 * @version 1.0
	 * @param workorderid
	 * @param remark
	 * @return
	 */
	@RequestMapping("/quit")
	@ResponseBody
	public String quitInfo(String omsMasterId,String workorderid,String remark){
		String response = quitWorkorService.quitWorkor(omsMasterId,workorderid,remark);
		return response;
	}

}
 