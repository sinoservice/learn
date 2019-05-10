package app;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.dao.TbOrderMapper;
import com.easyhome.po.TbOrder;
import com.easyhome.po.TbOrderExample;
import com.easyhome.po.TbOrderExample.Criteria;
import com.easyhome.vo.BaseResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class OrderTest {
	@Autowired
	private TbOrderMapper tbOrderMapper;

	@Test
	public void test() {
		BaseResponse response = new BaseResponse();
		TbOrderExample example = new TbOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo("8a80803f52f82174015382f33eb10fc6");
		List<TbOrder> selectByExample = tbOrderMapper.selectByExample(example);
		for (TbOrder order : selectByExample) {

			System.out.println(order.toString());
			BigDecimal checkstatus = order.getCheckstatus();
			System.out.println(checkstatus);
			response.setData(order);
			System.out.println(response);
		}

	}
}
