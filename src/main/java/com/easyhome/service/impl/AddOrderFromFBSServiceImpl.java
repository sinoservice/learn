package com.easyhome.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.dao.AddOrderFromFBSMapper;
import com.easyhome.service.AddOrderFromFBSService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
@Service("addOrderFromFBSService")
public class AddOrderFromFBSServiceImpl implements AddOrderFromFBSService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AddOrderFromFBSServiceImpl.class);
	@Resource
	private AddOrderFromFBSMapper addOrderFromFBSMapper;
	@Override
	public BaseResponse addOrderFromFBS(String out_order_sn) {
		BaseResponse response = new BaseResponse();
		try{
			addOrderFromFBSMapper.addOrderFromFBS(out_order_sn);
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo("订单添加成功");
			logger.info("订单添加成功");
		}catch(Exception e){
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("订单添加失败");
			logger.info("订单添加失败:"+e);
		}
		return response;
	}
}	
