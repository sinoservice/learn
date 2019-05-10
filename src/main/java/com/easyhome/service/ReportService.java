package com.easyhome.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyhome.vo.WorkOrderServiceStatusReportQueryVo;

/**
 * 
 * <p>title: ReportService</p>
 * <p>description: 报表服务接口</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月23日 下午5:59:39
 */
public interface ReportService {
	
	/**
	 * 
	 * <p>description: 获取工单服务状态报表excel文件流</p>
	 * @param queryVo
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @date 2016年7月23日 下午6:02:31
	 */
	public void createWorkOrderServiceStatusReport(WorkOrderServiceStatusReportQueryVo queryVo,HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	
	/**
	 * 
	 * <p>description: 生成放弃工单报表</p>
	 * @param queryVo
	 * @param request
	 * @param response
	 * @throws Exception
	 * @date 2016年7月25日 下午3:30:54
	 */
	public void createWorkOrderQuitReport(WorkOrderServiceStatusReportQueryVo queryVo,HttpServletRequest request,HttpServletResponse response) throws Exception;
}
