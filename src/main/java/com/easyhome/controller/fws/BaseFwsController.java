package com.easyhome.controller.fws;

import org.springframework.beans.factory.annotation.Autowired;

import com.easyhome.service.fws.AreaServiceI;
import com.easyhome.service.fws.BaseInfoServiceI;
import com.easyhome.service.fws.DispatchServiceI;
import com.easyhome.service.fws.MasterServiceI;
import com.easyhome.service.fws.SupplyServiceI;
/**
 * 
* @ClassName: BaseFwsController 
* @Description: TODO 服务商基类Controller,其他的需要继承此类，方便service的使用
* @date 2017年5月15日 下午7:21:01 
*
 */
public abstract class BaseFwsController {
	/**
	 * 查询服务范围接口
	 */
	@Autowired
	protected AreaServiceI areaServiceI;
	/**
	 * 基础数据与信息统一接口
	 */
	@Autowired
	protected BaseInfoServiceI baseInfoServiceI;
	/**
	 * 工单模块统一接口
	 */
	@Autowired
	protected DispatchServiceI dispatchSerivceI;
	/**
	 * 人员管理模块统一接口
	 */
	@Autowired
	protected MasterServiceI masterServiceI;
	/**
	 * 服务商App补充统一接口
	 */
	@Autowired
	protected SupplyServiceI supplyServiceI;

}
