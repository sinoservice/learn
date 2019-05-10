package com.easyhome.controller.oms;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.oms.BaseFunctionService;

/**
 * 
 * <p> Title: BaseFunctionController</p>
 * <p> Description: 基础信息接口</p>
 * 
 * @date 2016年6月17日 下午8:10:33
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/oms/baseFunction")
public class BaseFunctionController {
	
	@Autowired
	private BaseFunctionService baseFunctionService;

	/**
	 * 
	 * <p> Description: 基础数据接口</p>
	 * 
	 * @date 2016年6月17日 下午8:33:46
	 * @version 1.0
	 * @param code
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/baseData")
	@ResponseBody
	public Map<String, Object> baseData(@RequestParam(defaultValue="") String code) throws Exception{
		return baseFunctionService.getBaseData(code);
	}
	
	/**
	 * 
	 * <p> Description: 获取省市县</p>
	 * 
	 * @date 2016年6月20日 下午7:12:08
	 * @version 1.0
	 * @param provinceid
	 * @param cityid
	 * @return
	 */
	@RequestMapping("/getCity")
	@ResponseBody
	public String getCity(@RequestParam(defaultValue="") String provinceid,@RequestParam(defaultValue="") String cityid){
		//1.如果provinceid为空则查省分列表
		//2.如果cityid为空，则查省下的市
		//3.cityid不为空，provinceid为空则查市下的县
		return baseFunctionService.getCity(provinceid,cityid);
	}
	
}
