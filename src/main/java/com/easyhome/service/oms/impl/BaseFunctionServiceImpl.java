package com.easyhome.service.oms.impl;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easyhome.po.oms.BaseFunctionService;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.Util;
import com.easyhome.vo.oms.BaseDataResponse;
import com.easyhome.vo.oms.BaseDataResponseItems;
import com.google.gson.Gson;

/**
 * 
 * <p> Title: BaseFunctionServiceImpl</p>
 * <p> Description: 基础数据服务类</p>
 * 
 * @date 2016年6月17日 下午8:42:21
 * @version 1.0
 *
 */
@Service("baseFunctionService")
public class BaseFunctionServiceImpl implements BaseFunctionService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseFunctionServiceImpl.class);

	@Override
	public Map<String, Object> getBaseData(String code) throws Exception {
		logger.info(code);
		//TODO 与OMS对接
		
		//1.获取oms信息
		
		//方法名
		String methodName = "appGetBaseData";
		//地址
		String url = "APPSERVER/module-dms/httpServices/MDMSHttpService";
		//ip
		String ipAndPort = Util.getProperty("ipAndPort");
		url = url.replace("APPSERVER", ipAndPort);
		logger.info(url);
		//请求参数
		Map<String, String> inData = new HashMap<String, String>();
		inData.put("code", code);
		Gson gson = new Gson();
		String json = gson.toJson(inData);
		
		Map<String, Object> data = null;
		//2.请求网络
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("methodName", methodName);
			params.put("data", json );
			String post = HttpXmlClient.post(url, params);
			//解析
			BaseDataResponse fromJson = gson.fromJson(post, BaseDataResponse.class);
			
			if(fromJson!=null){
				data = new HashMap<String, Object>();
				List<Map<String, String>> list = new ArrayList<Map<String, String>>();
				List<BaseDataResponseItems> result = fromJson.result;
				if(result!=null && result.size()>0){
					//转换
					for (BaseDataResponseItems items : result) {
						Map<String, String> r = new HashMap<String, String>();
						r.put("FID", items.FID);
						r.put("CategoryCode", items.categorycode);
						r.put("Code", items.code);
						r.put("ParentId", items.parentid);
						r.put("Sortnum", items.sortnum);
						r.put("Status", items.status);
						r.put("Title", items.title);
						r.put("CategoryId", items.categorycode);
						list.add(r);
					}
				}
				data.put("errCode", fromJson.errCode);
				data.put("errMsg", fromJson.errMsg);
				data.put("result", list);
			}
		} catch (Exception e) {
			data.put("errCode", "-1");
			data.put("errMsg", "获取失败");
		}
		return data;
	}

	@Override
	public String getCity(String provinceid, String cityid) {
		
		logger.info("省ID："+provinceid);
		logger.info("市ID："+cityid);
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		//1.如果provinceid为空则查省分列表
//		if("".equals(provinceid) && "".equals(cityid)){
//			map.put("errCode", 0);
//			map.put("errMsg", "获取数据成功");
//			List<Map<String, String>> result = new ArrayList<Map<String, String>>();
//			//第1个省模拟
//			Map<String, String> p1 = new HashMap<String, String>();
//			p1.put("PROVINCEID", "1.0");
//			p1.put("PROVINCENAME", "北京市");
//			//第2个省模拟
//			Map<String, String> p2 = new HashMap<String, String>();
//			p2.put("PROVINCEID", "2.0");
//			p2.put("PROVINCENAME", "天津市");
//			result.add(p1);
//			result.add(p2);
//			map.put("result", result);
//		}
//		
//		//2.如果cityid为空，则查省下的市
//		if(!"".equals(provinceid) && "".equals(cityid)){
//
//			map.put("errCode", 0);
//			map.put("errMsg", "获取数据成功");
//			List<Map<String, String>> result = new ArrayList<Map<String, String>>();
//			//第1个市模拟
//			Map<String, String> c1 = new HashMap<String, String>();
//			c1.put("CITYID", "74.0");
//			c1.put("CITYNAME", "南京市");
//			c1.put("PROVINCEID", "10.0");
//			c1.put("ZIPCODE", "210000");
//			//第2个市模拟
//			Map<String, String> c2 = new HashMap<String, String>();
//			c2.put("CITYID", "75.0");
//			c2.put("CITYNAME", "南京市");
//			c2.put("PROVINCEID", "无锡市");
//			c2.put("ZIPCODE", "214000");
//			result.add(c1);
//			result.add(c2);
//			map.put("result", result);
//		}
//		
//		//3.cityid不为空，provinceid为空则查市下的县
//		if("".equals(provinceid) && !"".equals(cityid)){
//			map.put("errCode", 0);
//			map.put("errMsg", "获取数据成功");
//			List<Map<String, String>> result = new ArrayList<Map<String, String>>();
//			//第1个县模拟
//			Map<String, String> d1 = new HashMap<String, String>();
//			d1.put("CITYID", "105.0");
//			d1.put("DISTRICTID", "973.0");
//			d1.put("DISTRICTNAME", "迎江区");
//			Map<String, String> d2 = new HashMap<String, String>();
//			d2.put("CITYID", "105.0");
//			d2.put("DISTRICTID", "974.0");
//			d2.put("DISTRICTNAME", "大观区");
//			result.add(d1);
//			result.add(d2);
//			map.put("result", result);
//			
//		}
		
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("provinceid", provinceid);
			params.put("cityid", cityid);
			String data = OmsConnectUtil.getData("appGetGovernmentArea", params );
			return data;
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("errCode", -1);
			map.put("errMsg", e.getMessage());
			Gson gson = new Gson();
			return gson.toJson(map);
		}
	}
	
}
