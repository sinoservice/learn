package easyhome.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.dao.TbWorkOrderMapper;
import com.easyhome.po.TbWorkOrder;
import com.easyhome.po.TbWorkOrderBooking;
import com.easyhome.po.TbWorkOrderExample;
import com.easyhome.po.TbWorkOrderExample.Criteria;
import com.easyhome.service.WorkOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-mvc.xml"})
public class BookOrderServiceTest {
	
	@Autowired
	private WorkOrderService workOrderService;
	@Autowired
	private TbWorkOrderMapper tbWorkOrderMapper;
	
	@Test
	public void testSave() throws Exception {
		String workorderid = "4444";
		String linkman = "测试";
		String address = "测试";
		String phone = "13502074163";
		String status = "1";
		String reason = "未到货";
		String date = "2016-05-16 10:30:30";
		String call = "是";
		TbWorkOrderBooking orderBooking = workOrderService.saveOrderBooking(workorderid, linkman, address, phone, status, reason, date, call);
		System.out.println(orderBooking);
	}
	
	@Test
	public void testFindByFid() throws Exception {
		String fid = "a7ec4b70-02f2-4a12-9ed5-baeda86ac7a1";
		TbWorkOrder order = workOrderService.getBookOrderingByFId(fid);
		System.out.println(order.getOutOrderSn());
		System.out.println(order.getCheckCode());
	}
	
	@Test
	public void testall() throws Exception {
		String fid = "6e6bc5f4-7997-4d07-958c-f70d90de65eb";
		TbWorkOrderBooking workOrder= workOrderService.saveOrderBooking(fid, 
				"mrduan", "测试地址", "13502074163", "0", "预约成功", "2016-05-11 17:10:10", "是");
		TbWorkOrderExample example = new TbWorkOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo(fid);
		List<TbWorkOrder> list = tbWorkOrderMapper.selectByExample(example);
		System.out.println(list);
		String cusTel = list.get(0).getCusTel();
		System.out.println(cusTel);
		int infoMsg = workOrderService.sendBookInfoMsg(list.get(0), workOrder);
		System.out.println(infoMsg);
		
	}
	
	
	@Test
	public void testFindWorkOrder() throws Exception {
		boolean fid = workOrderService.findWorkOrderByFid("f84d627c-1132-4b89-8fc3-916a97e251e22");
		System.out.println(fid);
	}
	
	@Test
	public void testUpdateRevisit() throws Exception {
		workOrderService.updateAppraiseWorkOrder("f84d627c-1132-4b89-8fc3-916a97e251e2", 1, 2, 2, 2, 1);
		System.out.println("执行成功");
	}
	
	@Test
	public void testSave2() throws Exception {
		workOrderService.save("1", "2", 1463558711398l);
	}
	
	@Test
	public void testReprotMaster() throws Exception {
		//workOrderService.getSatisfiedByMaster(satisfiedByMasterQuery)
	}
}
