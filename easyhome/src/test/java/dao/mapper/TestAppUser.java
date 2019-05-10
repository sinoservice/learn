package dao.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.po.TbAppUser;
import com.easyhome.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-mvc.xml"})
public class TestAppUser {
	
	@Autowired
	private UserService userService;

	@Test
	public void testFindByPhone() throws Exception {
		String phone = "13502074163";
		TbAppUser appUser = userService.findTbAppUserByPhone(phone);
		System.out.println(appUser);
	}
}
