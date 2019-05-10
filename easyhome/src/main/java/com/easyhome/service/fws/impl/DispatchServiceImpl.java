package com.easyhome.service.fws.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.service.fws.DispatchServiceI;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ResourcesUtil;
/**
 * 
* @ClassName: DispatchServiceImpl 
* @Description: TODO 服务商派单统一接口实现类
* @date 2017年5月15日 下午5:14:24 
*
 */
@Service("dispatchServiceI")
public class DispatchServiceImpl implements DispatchServiceI {

	private static final Logger logger = Logger.getLogger(AreaServiceImpl.class);

	@Override
	public String findDispatchData(String method, String data) {
		String post = "";
		try {

			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "dispatch";
			
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
