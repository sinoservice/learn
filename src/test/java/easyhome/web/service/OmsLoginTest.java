package easyhome.web.service;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.dao.UserDao;
import com.easyhome.service.UserService;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.Util;
import com.easyhome.vo.oms.LoginResponseSoms;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-mvc.xml"})
public class OmsLoginTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OmsLoginTest.class);
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	@Test
	public void testLogin() throws Exception {

		// 1.请求供应商平台，查询是否为工人角色
		String somsAppAddr = Util.getProperty("somsAppAddr");
		String somsUrl = somsAppAddr + "findUser";
		Map<String, String> p = new HashMap<String, String>();
		p.put("phone", "13502074163");
		p.put("password", "123456");
		String somsReturn = HttpXmlClient.post(somsUrl, p);
		System.out.println(somsReturn);
		// 解析数据
		Gson gson = new Gson();
		LoginResponseSoms somsJson = gson.fromJson(somsReturn, LoginResponseSoms.class);

		if ("200".equals(somsJson.returnCode)) {// 成功找到工人信息
			System.out.println(somsJson);
		}
	}
	
	@Test
	public void testFindFid() throws Exception {
		String phone = "15625252506";
		//ist<String> list = userDao.findMasterIdByPhone(phone );
		//System.out.println(list);
	}
	
}
