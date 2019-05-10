package com.easyhome.service.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.easyhome.lbsService.LBSService;
import com.easyhome.lbsService.po.Coordinate;
import com.easyhome.service.SignService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;

@Service("signService")
public class SignServiceImpl implements SignService {

	Log log = LogFactory.getLog(SignServiceImpl.class);

	@Resource
	private LBSService lBSService;

	public BaseResponse getCoordinate(String address) {
		BaseResponse response = new BaseResponse();
		if(!Util.isEmpty(address)){
			try {
				Coordinate coordinate = lBSService.getCoordinate(address, null);
				if(coordinate!=null&&coordinate.getLat()>=0){
					response.setReturnCode(ReturnCode.STATUS_200);
					response.setInfo(ReturnCode.OK);
					response.setData(coordinate);
					log.info("获取地址坐标成功");
				}else{
					response.setReturnCode(ReturnCode.STATUS_400);
					response.setInfo("获取坐标失败");
					log.error(address+"获取坐标失败");
				}
			} catch (Exception e) {
				log.error("获取坐标异常",e);
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("获取坐标异常");
				
			}
		}else{
			response.setReturnCode(ReturnCode.STATUS_400);
			response.setInfo("客户地址为空");
			log.error(address+"客户地址为空");
		}
		return response;
	}

}
