package dao.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.dao.ReportMapper;
import com.easyhome.service.ReportService;
import com.easyhome.vo.WorkOrderQuitReportModel;
import com.easyhome.vo.WorkOrderServiceStatusReportModel;
import com.easyhome.vo.WorkOrderServiceStatusReportQueryVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-mvc.xml"})
public class ReportMapperTest {
	
	@Autowired
	private ReportMapper reportMapper;
	@Autowired
	private ReportService reportService;

	@Test
	public void WorkOrderServiceStatusReport() throws Exception {
		WorkOrderServiceStatusReportQueryVo queryVo = new WorkOrderServiceStatusReportQueryVo();
		queryVo.setBillDateStart("2016-05-01");
		queryVo.setBillDateEnd("2016-06-05");
		queryVo.setSendDateStart("2016-05-01");
		queryVo.setSendDateEnd("2016-06-05");
		queryVo.setRemark("未到货");
		List<WorkOrderServiceStatusReportModel> list = reportMapper.workOrderServiceStatusReport(queryVo);
		System.out.println(list);
	}
	
	@Test
	public void WorkOrderQuitReport() throws Exception {
		WorkOrderServiceStatusReportQueryVo queryVo = new WorkOrderServiceStatusReportQueryVo();
		queryVo.setBillDateStart("2016-03-01");
		queryVo.setBillDateEnd("2016-07-25");
		queryVo.setSendDateStart("2016-03-01");
		queryVo.setSendDateEnd("2016-07-25");
		//queryVo.setRemark("刷单");
		List<WorkOrderQuitReportModel> list = reportMapper.workOrderQuitReport(queryVo);
		System.out.println(list);
	}
	
	@Test
	public void testDownload() throws Exception {
		WorkOrderServiceStatusReportQueryVo queryVo = new WorkOrderServiceStatusReportQueryVo();
		queryVo.setBillDateStart("2016-03-01");
		queryVo.setBillDateEnd("2016-07-25");
		queryVo.setSendDateStart("2016-03-01");
		queryVo.setSendDateEnd("2016-07-25");
		
		try {
			reportService.createWorkOrderQuitReport(queryVo, null, null);
			System.out.println("导出成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
