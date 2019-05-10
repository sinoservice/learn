package com.easyhome.dao;

import java.util.List;

import com.easyhome.vo.WorkOrderQuitReportModel;
import com.easyhome.vo.WorkOrderServiceStatusReportModel;
import com.easyhome.vo.WorkOrderServiceStatusReportQueryVo;

/**
 * 
 * <p>title: ReportMapper</p>
 * <p>description: 报表接口</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月23日 下午4:21:33
 */
public interface ReportMapper {
	
	/**
	 * 
	 * <p>description: 工单服务状态报表</p>
	 * @return
	 * @date 2016年7月23日 下午4:22:50
	 */
	public List<WorkOrderServiceStatusReportModel> workOrderServiceStatusReport(WorkOrderServiceStatusReportQueryVo queryVo);
	
	/**
	 * 
	 * <p>description: 放弃工单报表</p>
	 * @param queryVo
	 * @return
	 * @date 2016年7月25日 下午2:54:05
	 */
	public List<WorkOrderQuitReportModel> workOrderQuitReport(WorkOrderServiceStatusReportQueryVo queryVo);
	
}
