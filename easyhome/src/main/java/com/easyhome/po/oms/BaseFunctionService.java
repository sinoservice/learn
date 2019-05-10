package com.easyhome.po.oms;

import java.util.Map;

/**
 * 
 * <p> Title: BaseFunctionService</p>
 * <p> Description: 基础功能实现类</p>
 * 
 * @date 2016年6月17日 下午8:39:53
 * @version 1.0
 *
 */
public interface BaseFunctionService {

	/**
	 * 
	 * <p> Description: 基础数据接口</p>
	 * 
	 * @date 2016年6月17日 下午8:41:30
	 * @version 1.0
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getBaseData(String code) throws Exception;

	/**
	 * 
	 * <p> Description: 获取省市县列表</p>
	 * 
	 * @date 2016年6月20日 下午7:17:17
	 * @version 1.0
	 * @param provinceid
	 * @param cityid
	 * @return
	 */
	public String getCity(String provinceid, String cityid);
}
