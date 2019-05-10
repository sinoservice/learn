package easyhome.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.easyhome.utils.Util;
import com.easyhome.vo.Goods;
import com.easyhome.vo.WorkOrderPartlyCompletedRequest;
import com.google.gson.Gson;

public class TestUtil {

		@Test
		public void testUtil() throws Exception {
			String sss = Util.getProperty("smsurl");
			System.out.println(sss);
			Goods go = new Goods();
			go.GOOD_NO = "DE0005";
			go.GOOD_LINEID = 1+"";
			go.ITEM_AMOUNT = 35+"";
			go.ACTUAL_AMOUNT = 35+"";
			go.IS_COMPLETEED = "N";
			go.UNCOM_REASON = "未到货";
			go.REMARK = "未到货后在施工";
		}
		
		@Test
		public void testJson() throws Exception {
			List<Goods> g = new ArrayList<Goods>();
			for(int i=0;i<3;i++){
				Goods go = new Goods();
				go.GOOD_NO = "DE0005"+i;
				go.GOOD_LINEID = 1+i+"";
				go.ITEM_AMOUNT = 35+i*3+"";
				go.ACTUAL_AMOUNT = 35+i*3-10+"";
				go.IS_COMPLETEED = "N";
				go.UNCOM_REASON = "未到货";
				go.REMARK = "未到货后在施工";
				g.add(go);
			}
			
			WorkOrderPartlyCompletedRequest partly = new WorkOrderPartlyCompletedRequest();
			partly.workorderid = "DL201604212146";
			partly.masterid = "026cd08f-13fa-4092-82d7-28a31d75385d";
			partly.remark = "客户原因";
			partly.phone = "13502074163";
			partly.name = "MrDuan";
			partly.address = "北京市朝阳区东三环南路98号";
			partly.items = g;
			partly.image = "aa|bb|cc";
			
			Gson gson = new Gson();
			String json = gson.toJson(partly);
			System.out.println(json);
		}
		
	
		@Test
		public void testGson() throws Exception {
			String workorderid = "1123345656";
			String remark = "woshiguos";
			
			Map<String, String> request = new HashMap<String, String>();
			request.put("workorderid", workorderid);
			request.put("remark", remark);
			
			Gson fGson = new Gson();
			String json2 = fGson.toJson(request);
			
			System.out.println(json2);
		}
		
		@Test
		public void testProtis() throws Exception {
			String url = "APPSERVER/module-dms/httpServices/MDMSHttpService";
			String ipAndPort = Util.getProperty("ipAndPort");
			url = url.replace("APPSERVER", ipAndPort);
			
			System.out.println(url);
		}
		 
		@Test
		public void testSub() throws Exception {
			String a = "jd13.19410777846";
			int index = a.indexOf(".");
			String substring = a.substring(index+1);
			System.out.println(substring);
		}
}
