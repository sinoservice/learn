package dao.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.dao.TbWorkOrderMapper;
import com.easyhome.dao.TbWorkOrderMapperCustom;
import com.easyhome.dao.UserDao;
import com.easyhome.po.TbWorkOrder;
import com.easyhome.po.TbWorkOrderExample;
import com.easyhome.po.User;
import com.easyhome.po.TbWorkOrderExample.Criteria;
import com.easyhome.vo.BadgeRanking;
import com.easyhome.vo.MasterBadge;
import com.easyhome.vo.PageQuery;
import com.easyhome.vo.ReminderWorkOrder;
import com.easyhome.vo.ReminderWorkOrderQuery;
import com.easyhome.vo.SatisfiedByMasterQuery;
import com.easyhome.vo.SatisfiedByWokeOrderCustom;
import com.easyhome.vo.SatisfiedByWokeOrderQuery;
import com.easyhome.vo.bos.OrderStatusBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class WorkOrderCustomTest {
	
	@Autowired
	private TbWorkOrderMapper tbWorkOrderMapper;
	
	@Autowired
	private TbWorkOrderMapperCustom tbWorkOrderMapperCustom;
	
	@Autowired
	private UserDao userDao;

	@Test
	public void testGetBadgeByMasterId() throws Exception {
		String masterId = "aa3cc163-fef3-481c-b77f-33986eb135aa";
		MasterBadge badgeByMasterId = tbWorkOrderMapperCustom.getBadgeByMasterId(masterId);
		System.out.println(badgeByMasterId);
	}
	
	@Test
	public void testBadgeRanking() throws Exception {
		String masterId = "aa3cc163-fef3-481c-b77f-33986eb135aa";
		List<BadgeRanking> rankingList = tbWorkOrderMapperCustom.findRankingList(masterId);
		System.err.println(rankingList);
	}
	
	@Test
	public void testGetReport() throws Exception {
		SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery = new SatisfiedByWokeOrderQuery();
		satisfiedByWokeOrderQuery.setStart("2015-01-01");
		satisfiedByWokeOrderQuery.setEnd("2016-05-25");
		List<SatisfiedByWokeOrderCustom> list = tbWorkOrderMapperCustom.calculateSatisfiedReportByOrderList(satisfiedByWokeOrderQuery);
		System.out.println(list);
	}
	
	@Test
	public void testGetList() throws Exception {
		SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery = new SatisfiedByWokeOrderQuery();
		satisfiedByWokeOrderQuery.setStart("2015-01-01");
		satisfiedByWokeOrderQuery.setEnd("2016-05-25");
		satisfiedByWokeOrderQuery.setPageSize(10);
		satisfiedByWokeOrderQuery.setCurrentPage(1);
		PageQuery pageQuery = new PageQuery();
		
		int count = tbWorkOrderMapperCustom.calculateSatisfiedReportByOrderCount(satisfiedByWokeOrderQuery);
		System.out.println(count);
		
		pageQuery.setPageParams(count, satisfiedByWokeOrderQuery.getPageSize(), satisfiedByWokeOrderQuery.getCurrentPage());
		
		satisfiedByWokeOrderQuery.setPageQuery(pageQuery);
		
		List<SatisfiedByWokeOrderCustom> list = tbWorkOrderMapperCustom.calculateSatisfiedReportByOrderList(satisfiedByWokeOrderQuery);
		
		System.out.println(list);
	}
	
	@Test
	public void testGetPronvince() throws Exception {
		List<String> province = tbWorkOrderMapperCustom.getProvince();
		System.out.println(province);
	}
	
	@Test
	public void getOrganiza() throws Exception {
		List<String> organize = tbWorkOrderMapperCustom.getOrganize();
		System.out.println(organize);
	}
	
	@Test
	public void testReprotMasterList() throws Exception {
		SatisfiedByMasterQuery query = new SatisfiedByMasterQuery();
		query.setStart("2016-01-01");
		query.setEnd("2016-05-26");
		query.setProvince("北京市");
		//List<SatisfiedByMasterCustom> list = tbWorkOrderMapperCustom.calulateSatisfiedByMasterList(query);
		//System.out.println(list);
	}
	
	@Test
	public void testReminder() throws Exception {
		ReminderWorkOrderQuery query = new ReminderWorkOrderQuery();
		query.setOvertime("4");
		int count = tbWorkOrderMapperCustom.findReminderWorkOrderCount(query);
		
		
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(count, 10, 1);
		query.setPageQuery(pageQuery);
		List<ReminderWorkOrder> list = tbWorkOrderMapperCustom.findReminderWorkOrderList(query);
		System.out.println(list);
	}
	
	
	@Test
	public void testUpdateBookingInfo() throws Exception {
		TbWorkOrderExample example = new TbWorkOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo("b96285ee-acc5-4a64-aea9-af5acbe29757");
		List<TbWorkOrder> list = tbWorkOrderMapper.selectByExample(example);
		TbWorkOrder order = list.get(0);
		order.setBookingTime(new Date());
		
		criteria.andFidEqualTo("b96285ee-acc5-4a64-aea9-af5acbe29757");
		List<TbWorkOrder> list1 = tbWorkOrderMapper.selectByExample(example);
		TbWorkOrder order1 = list1.get(0);
		Date bookingTime = order1.getBookingTime();
		System.out.println(bookingTime);
		int updateBookingInfo = tbWorkOrderMapperCustom.updateByExampleSelective(order, example);
		System.out.println(updateBookingInfo);
	}
	
	
	@Test
	public void testGetStatus() throws Exception {
		List<OrderStatusBean> list = tbWorkOrderMapperCustom.getWorkOrderStatus(5);
		
		System.out.println(list.size());
	}
	
	
	@Test
	public void testFindUserByPhone() throws Exception {
		User user = userDao.findByPhone("15625252506");
		System.out.println(user);
	}
}
