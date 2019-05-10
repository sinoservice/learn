package com.easyhome.service.oms.impl;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easyhome.service.oms.QuitWorkorService;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

/**
 * 
 * @date 2016 上午9:19:51
 * @version 1.0
 */
@Service
public class QuitWorkorServiceImpl implements QuitWorkorService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(QuitWorkorServiceImpl.class);

	@Override
	public String quitWorkor(String omsMasterId,String workorderid,String remark) {//,String remark
		BaseResponse response = new BaseResponse();
		Gson gson = new Gson();
		if(workorderid == null || "".equals(workorderid) ){
			response.setInfo("请输入放弃工单的ID号");
			response.setReturnCode(400);
		}
		if(remark ==null || "".equals(remark)){
			response.setInfo("请确定放弃原因");
			response.setReturnCode(400);
		}else{
			try {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("workorderid", workorderid);
				params.put("remark", remark);
				params.put("masterid", omsMasterId);
				String json = gson.toJson(params);
				logger.info(json);
				String data = OmsConnectUtil.getData("appRejectDispatch", params );
				String replace = data.replace("errCode", "returnCode").replace("errMsg", "info");
				logger.info(replace);
				return replace;
			} catch (Exception e) {
				response.setInfo("位置错误异常");
				response.setReturnCode(500);
			}
		}
		return gson.toJson(response);
	}

	

}
