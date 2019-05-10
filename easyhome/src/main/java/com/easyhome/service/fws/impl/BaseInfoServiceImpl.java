package com.easyhome.service.fws.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.service.fws.BaseInfoServiceI;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ResourcesUtil;
/**
 * 
* @ClassName: BaseInfoServiceImpl 
* @Description: TODO 服务商BaseInfo统一接口实现类
* @date 2017年5月15日 下午5:11:52 
*
 */
@Service("baseInfoServiceI")
public class BaseInfoServiceImpl implements BaseInfoServiceI {
	private static final Logger logger = Logger.getLogger(AreaServiceImpl.class);

	@Override
	public String findBaseData(String method, String data) {
		String post = "";
		try {

			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "baseInfo";
			
			Map<String, String> param = new HashMap<>();
			param.put("data", data);
			param.put("method", method);

			// 请求方法
			post = HttpXmlClient.post(url, param);
			
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务器异常", e);
		}
		return post;
	}
}
