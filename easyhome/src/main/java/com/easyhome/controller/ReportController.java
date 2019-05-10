package com.easyhome.controller;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.WorkOrderService;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.PageBean;
import com.easyhome.vo.SatisfiedByMasterCustom;
import com.easyhome.vo.SatisfiedByMasterQuery;
import com.easyhome.vo.SatisfiedByWokeOrderCustom;
import com.easyhome.vo.SatisfiedByWokeOrderQuery;
import com.easyhome.vo.WorkOrderServiceStatusReportQueryVo;

@Controller
@RequestMapping("/report")
public class ReportController implements Serializable{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReportController.class);
	
	@Autowired
	private WorkOrderService workOrderService;
	
	@Autowired
	private com.easyhome.service.ReportService reportService;

	private static final long serialVersionUID = -8148410892178759832L;
	
	/**
	 * 
	 * <p> Description: 以工单为维度查询满意度报表</p>
	 * 
	 * @date 2016年5月25日 下午6:23:31
	 * @version 1.0
	 * @param satisfiedByWokeOrderQuery
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/byOrder")
	@ResponseBody
	public BaseResponse getSatisfiedByOrder(@ModelAttribute SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery) throws Exception{
		BaseResponse br = new BaseResponse();
		try {
			PageBean pageBean = workOrderService.getSatisfiedByOrder(satisfiedByWokeOrderQuery);
			br.setReturnCode(0);
			br.setInfo("获取成功");
			br.setData(pageBean);
		} catch (Exception e) {
			br.setReturnCode(-1);
			br.setInfo("获取失败");
			e.printStackTrace();
		}
		return br;
	}
	
	/**
	 * 
	 * <p> Description: 以工单为维度查询满意度报表导出原始数据</p>
	 * 
	 * @date 2016年5月31日 上午10:49:54
	 * @version 1.0
	 * @param satisfiedByWokeOrderQuery
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/byOrderAll")
	@ResponseBody
	public BaseResponse getSatisfiedByOrderAll(@ModelAttribute SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery) throws Exception{
		BaseResponse br = new BaseResponse();
		try {
			List<SatisfiedByWokeOrderCustom> sbs = workOrderService.getSatisfiedByOrderAll(satisfiedByWokeOrderQuery);
			br.setReturnCode(0);
			br.setInfo("获取成功");
			br.setData(sbs);
		} catch (Exception e) {
			br.setReturnCode(0);
			br.setInfo("获取失败");
		}
		
		return br;
				
	}
	
	/**
	 * 
	 * <p> Description: 技师维度统计工单满意度</p>
	 * 
	 * @date 2016年5月31日 上午10:52:41
	 * @version 1.0
	 * @param satisfiedByMasterQuery
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/byMaster")
	@ResponseBody
	public BaseResponse getSatisfiedByMaster(@ModelAttribute SatisfiedByMasterQuery satisfiedByMasterQuery) throws Exception{
		
		BaseResponse br = new BaseResponse();
		try {
			PageBean pageBean = workOrderService.getSatisfiedByMaster(satisfiedByMasterQuery);
			br.setReturnCode(0);
			br.setInfo("获取成功");
			br.setData(pageBean);
		} catch (Exception e) {
			br.setReturnCode(-1);
			br.setInfo("获取失败");
			e.printStackTrace();
		}
		return br;
	}
	
	/**
	 * 
	 * <p> Description: 技师维度统计工单满意度.导出原始数据</p>
	 * 
	 * @date 2016年5月31日 上午10:53:06
	 * @version 1.0
	 * @param satisfiedByMasterQuery
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/byMasterAll")
	@ResponseBody
	public BaseResponse getSatisfiedByMasterAll(@ModelAttribute SatisfiedByMasterQuery satisfiedByMasterQuery) throws Exception{
		
		BaseResponse br = new BaseResponse();
		try {
			List<SatisfiedByMasterCustom> sbs = workOrderService.getSatisfiedByMasterAll(satisfiedByMasterQuery);
			br.setReturnCode(0);
			br.setInfo("获取成功");
			br.setData(sbs);
		} catch (Exception e) {
			br.setReturnCode(-1);
			br.setInfo("获取失败");
			e.printStackTrace();
		}
		return br;
	}


	
	/**
	 * 
	 * <p> Description: 获取省份列表</p>
	 * 
	 * @date 2016年5月27日 下午1:44:57
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/province")
	@ResponseBody
	public BaseResponse province(){
		List<String> province = workOrderService.getProvince();
		BaseResponse br = new BaseResponse();
		if(province.size() ==0 || province == null){
			br.setReturnCode(-1);
			br.setInfo("请求失败！");
		}else{
			br.setReturnCode(0);
			br.setInfo("请求成功！");
			br.setData(province);
		}
		return br;
	}
	
	/**
	 * 
	 * <p> Description: 获取调度平台列表</p>
	 * 
	 * @date 2016年5月27日 下午1:47:47
	 * @version 1.0
	 * @return
	 */
	@RequestMapping("/organiza")
	@ResponseBody
	public BaseResponse organiza(){
		List<String> organiza = workOrderService.getOrganiza();
		BaseResponse br = new BaseResponse();
		if(organiza.size() ==0 || organiza == null){
			br.setReturnCode(-1);
			br.setInfo("请求失败！");
		}else{
			br.setReturnCode(0);
			br.setInfo("请求成功！");
			br.setData(organiza);
		}
		return br;
	}
	
	/**
	 * 
	 * <p>description: 工单服务状态报表下载</p>
	 * @param queryVo
	 * @date 2016年7月25日 下午2:45:26
	 * @throws Exception 
	 */
	@RequestMapping(value="/downloadWorkServiceReport")
	@ResponseBody
	public void downloadWorkServiceReport(WorkOrderServiceStatusReportQueryVo queryVo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info(queryVo);
		reportService.createWorkOrderServiceStatusReport(queryVo, request, response);
	}
	
	
	/**
	 * 
	 * <p>description: 工单放弃报表下载</p>
	 * @param queryVo
	 * @date 2016年7月25日 下午3:16:51
	 * @throws Exception 
	 */
	@RequestMapping(value="/downloadWorkQuitReport")
	@ResponseBody
	public void downloadWorkQuitReport(WorkOrderServiceStatusReportQueryVo queryVo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info(queryVo);
		reportService.createWorkOrderQuitReport(queryVo, request, response);
	}
}
