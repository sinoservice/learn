package app;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.po.tms.WorkerComplete;
import com.easyhome.service.fws.MasterServiceI;
import com.easyhome.service.tms.WorkerServiceI;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mybatis.xml","/spring-mvc.xml"})
public class WorkerTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkerTest.class);

	@Autowired
	private WorkerServiceI workerService;
	
	@Autowired
	private MasterServiceI masterService;
	
    @Test
	public void testWorker() {
    	WorkerComplete workerComplete = new WorkerComplete();
    	workerComplete.setFid("6");
    	workerComplete.setAge("21");
    	workerComplete.setName("小新");
    	workerComplete.setMasterId("666");
    	workerComplete.setChat("466789");
    	workerComplete.setIdentitycard("12345679");
    	workerComplete.setWorktypes("浴缸");
    	workerComplete.setSex("女");
    	workerComplete.setBankaccount("李秋实");
    	workerComplete.setBankname("北京银行");
    	workerComplete.setBanknumber("00000000");
    	workerComplete.setBranch("九龙山支行");
    	workerComplete.setPhone("110200");
    	workerComplete.setInsurance("有");
    	workerComplete.setTools("无");
    	/*workerComplete.setImages1("000");
    	workerComplete.setImages2("111");
    	workerComplete.setImages3("333");*/
    	workerComplete.setRelationship("情敌");
    	workerComplete.setSoslinkman("张杰");
    	workerComplete.setLinkphone("110120");
    	workerComplete.setRemark("what's dawn!");
		try {
			String a = workerService.completeWorkerDetails(workerComplete);	
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("",e);
		} 
	}
    
    @Test
	public void testName() throws Exception {
    	
    	Gson gson = new Gson();
    	
    	Map<String, String > map = new HashMap<String, String>();
    	map.put("phone", "13502074163");
    	map.put("password", "123456");
    	
    	String json = gson.toJson(map);
    	System.out.println(json);
    	String data = json;
    	String method = "login";
		String string = masterService.findMasterData(method, data);
		
		System.out.println(string);
		
	}
}
