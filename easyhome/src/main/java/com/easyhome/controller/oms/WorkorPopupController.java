package com.easyhome.controller.oms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.oms.WorkorPopupRequest;
import com.easyhome.service.oms.WorkorPopupService;
import com.easyhome.vo.BaseResponse;

@Controller
@RequestMapping("/oms/workor")
public class WorkorPopupController {
    @Autowired
    private WorkorPopupService workorPopupServiceI;
    @RequestMapping("/popup")
    @ResponseBody
	public BaseResponse workorPopup( WorkorPopupRequest request) {
		BaseResponse response = workorPopupServiceI.quitWorkor(request);
		return response;
	}

}
