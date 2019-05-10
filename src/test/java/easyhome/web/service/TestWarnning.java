package easyhome.web.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.easyhome.utils.HttpClientUtil;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

public class TestWarnning {

	@Test
	public void testWarnningCount() throws Exception {
		
		Gson gson = new Gson();
		try {
			//获取请求路径
			String path = ResourcesUtil.getValue("config", "warnningIp");
			String url = path+"services/AppWlSignSubWarning/getCountByType/";
			
			//传递参数
			Map<String, String> params = new HashMap<>();
			params.put("masterId", "YAJ20160310A095701");
			String json = gson.toJson(params);
			
			//发送请求
			String post = HttpClientUtil.postJson(url, json);
			System.out.println(post);
			
		} catch (Exception e) {//异常处理
			BaseResponse br = new BaseResponse();
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("服务器异常");
			System.out.println(gson.toJson(br));
		}
	}
	
	
	@Test
	public void testWarnningPage() throws Exception {
		
		Gson gson = new Gson();
		try {

			// 获取请求路径
			String path = ResourcesUtil.getValue("config", "warnningIp");
			String url = path + "services/AppWlSignSubWarning/queryPageList/";

			// 传递参数
			Map<String, Object> params = new HashMap<>();
			params.put("masterId", "YAJ20160310A100101");
			params.put("type", "0");
			params.put("startIndex", 0);
			params.put("pageSize", 10);
			String json = gson.toJson(params);

			// 发送请求
			String post = HttpClientUtil.postJson(url, json);
			//return post;
			System.out.println(post);
		} catch (Exception e) { //异常处理
			BaseResponse br = new BaseResponse();
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("服务器异常");
			String json = gson.toJson(br);
			System.out.println(json);
		}
	}
	
	@Test
	public void testMsg() throws Exception {
		String mobile = "13502074163";
		String content = "测试一条测试短信，来自接口";
		
		String url = "http://10.0.254.112:8091/serve/app/send";
		
		Map<String, String> params = new HashMap<>();
		params.put("mobile", mobile);
		params.put("content", content);
		String post = HttpXmlClient.post(url, params);
		
		System.out.println(post);
	}
	
}
