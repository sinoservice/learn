package easyhome.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.service.OrderServiceForBos;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-mvc.xml"})
public class OrderServiceTest {
	
	@Autowired
	private OrderServiceForBos orderServiceForBos;

	
	@Test
	public void testParseDateAndSave() throws Exception {
		String data = Util.getProperty("data");
		
		BaseResponse saveOrder = orderServiceForBos.parseAndSaveOrder(data);
		
		System.out.println(saveOrder);
	}
}
