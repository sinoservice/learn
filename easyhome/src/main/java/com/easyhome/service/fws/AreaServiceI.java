package com.easyhome.service.fws;
/**
 * 
* @ClassName: AreaServiceI 
* @Description: TODO 服务商查询服务区域统一接口
* @date 2017年5月15日 下午5:22:59 
*
 */
public interface AreaServiceI {
	/**
	 * 
	* @Title: findArea 
	* @Description: TODO 查询服务区域接口
	* @param ebplType
	* @param ebplCode
	* @param ebplParentPmCode
	* @return 
	* String    
	* @throws 
	* @date 2017年5月15日 下午5:37:03
	 */
	String findArea(String method,String data);
}
