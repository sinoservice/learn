package dao.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.dao.TbWorkOrderBookingMapper;
import com.easyhome.po.TbWorkOrderBooking;
import com.easyhome.po.TbWorkOrderBookingExample;
import com.easyhome.po.TbWorkOrderBookingExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("/spring-mybatis.xml")
public class BookingTest {
	
	@Autowired
	private TbWorkOrderBookingMapper tbWorkOrderBookingMapper;

	@Test
	public void testFindById() throws Exception {
		
		TbWorkOrderBookingExample example = new TbWorkOrderBookingExample();
		Criteria criteria = example.createCriteria();
		criteria.andWorkOrderIdEqualTo("8a80803f52f8217401537e2f91a20bb9");
		List<TbWorkOrderBooking> list = tbWorkOrderBookingMapper.selectByExample(example);
		System.out.println(list);
	}
	
	@Test
	public void testSaveBooking() throws Exception {
		TbWorkOrderBooking booking = new TbWorkOrderBooking();
		booking.setAddress("测试地址");
		booking.setBookingTime(new Date());
		booking.setCallPhone("是");
		booking.setCreateTime(new Date());
		booking.setFid("QQQQ");
		booking.setPhone("13502074163");
		booking.setRemark("未到货");
		booking.setStatus((short) 1);
		booking.setStatusDisplay("失败");
		booking.setWorkOrderId("WWWW");
		int i = tbWorkOrderBookingMapper.insert(booking);
		System.out.println(i);
		System.out.println(booking);
	}
}
