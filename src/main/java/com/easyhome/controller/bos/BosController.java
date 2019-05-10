package com.easyhome.controller.bos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.OrderServiceForBos;
import com.easyhome.vo.BaseResponse;

/**
 * 
 * <p>title: BosController</p>
 * <p>description: BOS系统交互控制器</p>
 * <p>公司名称：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年8月4日 下午10:03:54
 */
@Controller
@RequestMapping("/bos")
public class BosController {
	
	@Autowired
	private OrderServiceForBos orderServiceForBos;
	
	
	/**
	 * 
	 * <p>description: 保存工单信息</p>
	 * @param data
	 * @return
	 * @throws Exception
	 * @date 2016年8月7日 下午2:25:33
	 */
	@RequestMapping(value="/acceptBosOrder")
	@ResponseBody
	public BaseResponse acceptBosOrder(String data) throws Exception{
		BaseResponse br = orderServiceForBos.parseAndSaveOrder(data);
		return br;
	}
	
	
	@RequestMapping(value="/getStatus")
	@ResponseBody
	public BaseResponse getWorkOrderStatus(int status) throws Exception{
		BaseResponse br = orderServiceForBos.getWorkOrderStatus(status);
		return br;
	}
}
