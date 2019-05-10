package easyhome;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.easyhome.utils.DateUtil;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.MD5;
import com.easyhome.utils.OmsConnectUtil;
import com.google.gson.Gson;

public class HttpXmlClientTest {

	@Test
	public void testPost() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("mobile", "15012681069");
		params.put("content", "测试短信，请勿回复");
		//String post = HttpXmlClient.post("http://58.252.73.94/serve/app/send", params);
		Gson gson=new Gson();
		String str=gson.toJson(params);
		Map<String, String> param = new HashMap<String, String>();
		param.put("data", str);
		System.out.println(params);
		System.out.println(str);
		System.out.println(param);
	}
	
	@Test
	public void testBooking() throws Exception {
		String url = "http://192.168.8.33:8088/App/SaveWorkOrderBooking";
		Map<String, String> params = new HashMap<String, String>();
		params.put("workorderid", "8a80803f52f8217401537e4b23ad0c13");
		params.put("linkman", "T01箭牌.周紫鹃");
		params.put("address", "甘肃省兰州市城关区渭源路街道渭源路135号地震局家属院");
		params.put("phone", "18109409667");
		params.put("status", "1");
		params.put("reason", "未到货");
		params.put("date", "2016-05-15 10:00:00");
		params.put("call", "是");
		
		
		String post = HttpXmlClient.post(url, params);
		System.out.println(post);
	}
	
	@Test
	public void testHttpPost() throws Exception {
		//通过http
	}
	
	
	@Test
	public void testChange() throws Exception {
		BigDecimal bigDecimal = new BigDecimal(2);
		System.out.println(bigDecimal);
	}
	
	@Test
	public void testDate() throws Exception {
		String time = "2016-05-13 12:30";
		String[] split = time.split(":");
		if(split.length==2){
			time = time +":00";
		}
		System.out.println(time);
		Date date = DateUtil.string2date(time, DateUtil.YYYY_MM_DD_HH_MM_FORMAT);
		System.out.println(date);
	}
	
	@Test
	public void testSubString() throws Exception {
		String tt = "2016-12-12";
		String string = tt.substring(0, 10);
		System.out.println(string);
	}
	
	@Test
	public void testTime() throws Exception {
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
	}

	public static void main(String[] args) {
		String md5_pwd = MD5.MD5Encode("008873").toUpperCase();
		System.out.println(md5_pwd);
//		LoginRequest request=new LoginRequest();
//		request.setPhone("1213");
//		request.setPassword("1231");
//		String data=JSONObject.fromObject(request).toString();
////		String url="http://localhost:8088/eaju_app_service/sms/getSms?"+1232312;
////		String result=HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
////		System.out.println(result);
//		System.out.println(data);
//		JSONObject jsonObject=JSONObject.fromObject(data);
////	
//		System.out.println(jsonObject);
//		
//		String url="http://app.51eaju.com:82/APP/SendSms";
//		Map<String,String> params =new HashMap<>();
//		params.put("phone", "18510906497");
//		String code=HttpXmlClient.post(url, params);
//		System.out.println(code);
	}

	
	@Test
	public void testDouble() throws Exception {
		DecimalFormat df = new DecimalFormat("######0.0");
		
		double b = (double)100/(double)3;
		String format = df.format(b);
		
		
		System.out.println(format);
	}
	
	
	
	@Test
	public void testTimes() throws Exception {
		String time = "2016-05-26";
		int length = time.length();
		String string = time.substring(0, 10);
		System.out.println(length);
		System.out.println(string);
	}

	@Test
	public void testSearch() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		params.put("searchWords ", "DL201604212102");
		params.put("pagesize", "1");
		params.put("pageIndex", "5");
		params.put("masterid", "YAJ20160303A0001");
		String methodName="appQueryDispatchOrderVague";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
	}
	//登录
	@Test
	public void testLogin() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
//		String md5_pwd = MD5.MD5Encode("123456");
//		System.out.println(md5_pwd);
		String md5_pwd = MD5.MD5Encode("123456").substring(8,24);
		System.out.println("....."+md5_pwd);
		params.put("phone", "18510906497");
		params.put("password", md5_pwd);
		
		String methodName="appUserLogin";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
	}
	@Test
	public void testfindWorkOrder() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		String md5_pwd = MD5.MD5Encode("123456").toUpperCase();
		System.out.println(md5_pwd);
//		params.put("phone", "18902123081");
//		params.put("password", md5_pwd);
//		
//		String methodName="appUserLogin";
//		String data = OmsConnectUtil.getData(methodName, params);
//		System.out.println(data);
		
	}
	public void findWorkOrder() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		
//		params.put("phone", "18902123081");
//		params.put("password", md5_pwd);
		
		String methodName="appUserLogin";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
		
		
	}
	/**
	 * 注册
	 * @throws Exception
	 */
	@Test
	public void testregister() throws Exception{
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("phone","18510906497");
		params.put("sex","1");
		params.put("name","邓超文");
		params.put("verificatecode","343860");
		params.put("masterfrom","1");
		params.put("age","2");
		params.put("chat","1232456");
		params.put("identitycard","4103231663");
		params.put("city","北京市朝阳区十里河");
		params.put("worktype","1");
		params.put("havecar","1");
		params.put("havetools","1");
		params.put("havainsurance","1");
		params.put("servicearea","北京市朝阳区");
		params.put("bankaccount","邓超文");
		params.put("bank_name","北京银行");
		params.put("branch","成寿寺支行");
		params.put("banknumber","621022365463");
		params.put("soslinkman","李白");
		params.put("relationship","朋友");
		params.put("linkphone","15625252506");
		params.put("image1"," ");
		params.put("image2"," ");
		params.put("image3"," ");
		params.put("remark","无");
		params.put("referee","");
		params.put("refer_phone","");
//		Gson gson = new Gson();
//		String json = gson.toJson(params);
//		System.out.println(json);
		String methodName="appUserRegister";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
	}
	/**
	 * 注册短信
	 * @throws Exception
	 */
	@Test
	public void getCode() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		
		params.put("phone", "13502074163");
		String methodName="appRegSendCodeToPhone";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
	}
	/**
	 * 修改密码
	 * @throws Exception
	 */
	@Test
	public void updatePassword() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		String md5_pwd = MD5.MD5Encode("122456").substring(8,24);
		String new_pwd = MD5.MD5Encode("123456").substring(8,24);
		System.out.println(md5_pwd);
		params.put("userid", "18510906497");
		params.put("oldpassword", md5_pwd);
		params.put("password", new_pwd);
		String methodName="appChangePassword";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
	}
	/**
	 * 忘记密码
	 * @throws Exception
	 */
	@Test
	public void AlterPassword() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		String md5_pwd = MD5.MD5Encode("123456").substring(8,24);
		System.out.println(md5_pwd);
		params.put("phone", "13502074163");
		params.put("code", "1234");
		params.put("password", md5_pwd);
		String methodName="appForgetPassword";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
	}
	/**
	 * 忘记密码短信
	 * @throws Exception
	 */
	@Test
	public void testappCode() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		String md5_pwd = MD5.MD5Encode("123456").toUpperCase();
		System.out.println(md5_pwd);
		params.put("phone", "18510906497");
		params.put("code", "1234");
		
		String methodName="appRecVerificateCode";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
	}
	
	@Test
	public void balance() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		
		params.put("masterid", "YAJ20160309A050101");
		params.put("startdate", "2016/06/01 12:12:12");
		params.put("enddate", "2016/07/20 12:12:12");
		params.put("pageIndex", "1");
		params.put("pagesize", "10");
		String methodName="appQueryAccounts";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
	}
	@Test
	public void findOrder() throws Exception{
		Map<String ,Object> params=new HashMap<String ,Object>();
		
		params.put("code", "001");
		
		String methodName="appGetBaseData";
		String data = OmsConnectUtil.getData(methodName, params);
		System.out.println(data);
		
		
		
	}
}
