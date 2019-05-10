package com.easyhome.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyhome.dao.ReportMapper;
import com.easyhome.service.ReportService;
import com.easyhome.utils.ExcelUtil;
import com.easyhome.vo.WorkOrderQuitReportExcel;
import com.easyhome.vo.WorkOrderQuitReportModel;
import com.easyhome.vo.WorkOrderServiceStatusReportExcel;
import com.easyhome.vo.WorkOrderServiceStatusReportModel;
import com.easyhome.vo.WorkOrderServiceStatusReportQueryVo;

/**
 * 
 * <p>title: ReportServiceImpl</p>
 * <p>description: 报表服务实现类</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月23日 下午6:07:17
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportMapper reportMapper;

	@Override
	public void createWorkOrderServiceStatusReport(WorkOrderServiceStatusReportQueryVo queryVo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		queryVo = queryVo==null?new WorkOrderServiceStatusReportQueryVo():queryVo;
		switch (queryVo.getRemark()) {
		
//		<option value="0">全部</option>
//		<option value="1">施工进度未到</option>
//		<option value="2">未到货</option>
//		<option value="3">客户不接电话</option>
//		<option value="4">暂不安装</option>
//		<option value="5">顾客换货</option>
//		<option value="6">时间冲突</option>
//		<option value="7">电话号码不正确</option>
		case "0":
			queryVo.setRemark("");
			break;
		case "1":
			queryVo.setRemark("施工进度未到");
			break;
		case "2":
			queryVo.setRemark("未到货");
			break;
		case "3":
			queryVo.setRemark("客户不接电话");
			break;
		case "4":
			queryVo.setRemark("暂不安装");
			break;
		case "5":
			queryVo.setRemark("顾客换货");
			break;
		case "6":
			queryVo.setRemark("时间冲突");
			break;
		case "7":
			queryVo.setRemark("电话号码不正确");
			break;
		default:
			break;
		}
		//1.获取数据
		List<WorkOrderServiceStatusReportModel> list = reportMapper.workOrderServiceStatusReport(queryVo);
		//2.设置response编码格式
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		String outName = "工单满意度报表";
		response.setHeader("Content-Disposition","attachment;filename = "+
		new String(outName.getBytes("GBK"),"ISO8859-1")+".xlsx");
		//构造Excel
		ExcelUtil.getInstance().exportObjToOutputStream(response.getOutputStream(), list, WorkOrderServiceStatusReportExcel.class, true);
	}

	@Override
	public void createWorkOrderQuitReport(WorkOrderServiceStatusReportQueryVo queryVo,HttpServletRequest request,HttpServletResponse response) throws Exception {
		queryVo = queryVo==null?new WorkOrderServiceStatusReportQueryVo():queryVo;
		switch (queryVo.getRemark()) {
		case "0":
			queryVo.setRemark("");
			break;
		case "1":
			queryVo.setRemark("超出服务区域");
			break;
		case "2":
			queryVo.setRemark("顾客已退货");
			break;
		case "3":
			queryVo.setRemark("工单重复");
			break;
		case "4":
			queryVo.setRemark("其它");
			break;
		case "5":
			queryVo.setRemark("自行安装");
			break;
		case "6":
			queryVo.setRemark("费用低");
			break;
		case "7":
			queryVo.setRemark("时间冲突");
			break;
		case "8":
			queryVo.setRemark("无法施工");
			break;
		case "9":
			queryVo.setRemark("跨品类");
			break;
		case "10":
			queryVo.setRemark("刷单");
			break;
		default:
			break;
		}
		//1.获取数据
		List<WorkOrderQuitReportModel> list = reportMapper.workOrderQuitReport(queryVo);
		//2.设置response编码格式
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		String outName = "放弃工单报表";
		response.setHeader("Content-Disposition","attachment;filename = "+
		new String(outName.getBytes("GBK"),"ISO8859-1")+".xlsx");
		
		//3.构造Excel
		ExcelUtil.getInstance().exportObjToOutputStream(response.getOutputStream(), list, WorkOrderQuitReportExcel.class, true);
		
	}

}
