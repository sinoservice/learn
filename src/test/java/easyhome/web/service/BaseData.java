package easyhome.web.service;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.easyhome.utils.FileReadUtil;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ImageUtil;
import com.easyhome.utils.MD5;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.Util;
import com.easyhome.vo.Goods;
import com.easyhome.vo.WorkOrderPartlyCompletedRequest;
import com.easyhome.vo.oms.BaseDataResponse;
import com.easyhome.vo.oms.LoginResponseOms;
import com.easyhome.vo.oms.LoginResponseResultCustom;
import com.easyhome.vo.oms.LoginResponseResultOms;
import com.google.gson.Gson;

public class BaseData {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(BaseData.class);
	
	String image001 = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDABsSFBcUERsXFhceHBsgKEIrKCUlKFE6PTBCYFVlZF9V"
+"XVtqeJmBanGQc1tdhbWGkJ6jq62rZ4C8ybqmx5moq6T/2wBDARweHigjKE4rK06kbl1upKSkpKSk"
+"pKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKT/wAARCADMAJkDASIA"
+"AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA"
+"AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3"
+"ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm"
+"p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA"
+"AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx"
+"BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK"
+"U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3"
+"uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDC82T+"
+"+fzo8x/77fnTaKAF3sf4j+dGT6mkpaADJ9TRzRijBoAKKXBo2nFACdKAaDkUDpQAUo4ptFADqMU2"
+"igQu00lFFAwooooAKXmkooAXFLigClAoATFLilxTgKAG4oxUgWl20AR7aXFSbaNlAEEnGKYKkmHI"
+"qOgQUooxkUgoAKKdikxQAlFOxijFADaKXFGKBhRilxRigCTbShadinbaAGom5gOmTWumhSMoImXn"
+"2rLC1KpYdz+dJ3A0f7Bl/wCeqflSf2HMP+WifrVIM/8AeP504PJ/fb86NQ0Lf9hz/wB9P1qObSZ4"
+"Y2dipA9DTBNNj/WP+dI0kjKQXYg9iaWoaGbOp3dKYI29DVyRcU+MZWqEUY0JB4p3lkdqtWy5BFSl"
+"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"
+"C0lFFAhaKSigBaKSigBaKKSgBaKSigBaSiigYUUlFAhaKSigAooooAWikpaBn//Z"
+"|/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDABsSFBcUERsXFhceHBsgKEIrKCUlKFE6PTBCYFVlZF9V"
+"XVtqeJmBanGQc1tdhbWGkJ6jq62rZ4C8ybqmx5moq6T/2wBDARweHigjKE4rK06kbl1upKSkpKSk"
+"pKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKSkpKT/wAARCADMAJkDASIA"
+"AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA"
+"AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3"
+"ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm"
+"p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA"
+"AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx"
+"BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK"
+"U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3"
+"uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDXooop"
+"AFJRRQAUUlFABSUtJQAUlLSUAJRQabmgBaTNITSZoAXNJmkzSZoAXNGaTNJSGOpM0UUAW6SikpiF"
+"opKKACikzQTQAUlGaTNABmkzSE0maAAmkzRTTQAuaTNJmkzQAuaKTNJmkAuaKbmlzQMcKXFNFLzQ"
+"BaopM0maBC0maKSmAZooopAFJRQaAEpppTTC1ACmmk00vTC9AD80haoy1JmgB+6jNMzRmgB4NKDT"
+"KcDQMeKXimg0uTQBapKKSgQtFJQTQAtJSFqaWpgPJpjPTC1MLUgHM9Rs9NJphNAxS1JmkozQAtGa"
+"SigB1FJRQIcDS5popRQMeKXJ9KZml3e9AFykJpuaQmgQ4tSZpuaTNACk000pppoGITTDT6aRQAwi"
+"mmnmmkUCG0lOpDTASiiikAuaM0lFADqKbS5oAcDRSA0ZoAtZopKKAFoooFABSUtHvTAaaQ040hoA"
+"YRTSKeaQ0ARkUhFPxSGgBmKMU7FJigBuKMU6koASlpM0uaQBRmjNFMZaooopCAUtJRTAWikooAKD"
+"7UfpSUAJikxTqaaAENJigmmlqAA00mkJptACk0lFJSAWikooAdRSUUDLlFFFMQUUUlAC0UlGaAFp"
+"KQmmmgBS1NJNBppoAQ0hpabQAhpKWkoASilpKAEpaSloAWigUUDLlFJupN1AhaM03dSbqAHZpM03"
+"dSb6QDqSm7hSbqYDjSGm7qTdQAppDSbqTdQAtFN3UbqAFpKTdRuoAWikzRmgBaWkooGTF6aXqAvS"
+"b6QiffSb6g30m+gCffSb6g3GjJoAm303fUeaKYD99G+mUUgHbqMmm0tMBc0tNpaAFpRSUopALSik"
+"FLQAoozQKKYyvmkpKWgQUUUUAFLSUUgFzRSUtABS0lFMBaKSloAWlptLSAWlFJSigBRS0UtACiko"
+"FLQBVooopgFFFFAC0UlFAC0UUUALRSUtABS0lFAC0tJRQAopwpop4pAFKKTNGaAHUUmaMn1pgVqK"
+"KM0hhS0lFMQtFFFIYUtJRTELRSUooAWikpRQAtFJS0AOFLmmg0UAOopAaKAHUlFLQB//2Q==";

	@Test
	public void testBaseData() throws Exception {
		//方法名
		String methodName = "appGetBaseData";
		//地址
		String url = "APPSERVER/module-dms/httpServices/MDMSHttpService";
		//ip
		String ipAndPort = Util.getProperty("ipAndPort");
		
		url = url.replace("APPSERVER", ipAndPort);
		logger.info(url);
		Map<String, String> data = new HashMap<String, String>();
		data.put("code", "002");
		Gson gson = new Gson();
		
		String json= gson.toJson(data);
		Map<String, String> params = new HashMap<String, String>();
		params.put("methodName", methodName);
		
		params.put("data", json );
		String post = HttpXmlClient.post(url, params);
		
		BaseDataResponse fromJson = gson.fromJson(post, BaseDataResponse.class);
		
		logger.info(fromJson);
		
		
		logger.info(post);
		
	}
	
	
	@Test
	public void testModel() throws Exception {
		//方法名
		String methodName = "appGetEmployeeMedal";
		//地址
		String url = "APPSERVER/module-dms/httpServices/MDMSHttpService";
		//ip
		String ipAndPort = Util.getProperty("ipAndPort");
		
		url = url.replace("APPSERVER", ipAndPort);
		logger.info(url);
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("masterId", "YAJ20160309A022501");
		Gson gson = new Gson();
		
		String json= gson.toJson(data);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("methodName", methodName);
		params.put("data", json );
		
		String post = HttpXmlClient.post(url, params);
		
		logger.info(post);
	}
	
	@Test
	public void testQr() throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("workOrderId", "DL201604212102");
		data.put("evalServiceComplete", "1");
		data.put("evalPhoneBack", "0");
		data.put("satisfaction1", "5");
		data.put("satisfaction2", "5");
		data.put("satisfaction3", "5");
		data.put("customerEval", "联调测试");
		Gson g = new Gson();
		String json = g.toJson(data);
		logger.info(json);
		String data2 = OmsConnectUtil.getData("appRecVisitResult", json);
		logger.info(data2);
	}
	
	
	@Test
	public void testLogin() throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("phone", "15110272604");
		String password = MD5.MD5Encode("654321").substring(8, 24);
		data.put("password", password);
		
		Gson g = new Gson();
		String json = g.toJson(data);
		logger.info(json);
		String data2 = OmsConnectUtil.getData("appUserLogin", json);
		logger.info(data2);
		
		//解析数据
		LoginResponseOms fromJson = g.fromJson(data2, LoginResponseOms.class);
		System.out.println(fromJson);
		
		LoginResponseResultCustom lc = new LoginResponseResultCustom();
		LoginResponseResultOms result = fromJson.result;
		//BeanUtils.copyProperties(result, lc,new String[]{"MASTER_ID"});
		lc.DRIVER_ID = result.DRIVER_ID;
		lc.FID = result.FID;
		lc.IS_MODIFY_PWD = result.IS_REGISTERED;
		lc.NAME = result.NAME;
		lc.PHONE = result.PHONE;
		lc.PLAT_FROM_ID = result.PLAT_FROM_ID;
		lc.PLAT_FROM_NAME = result.PLAT_FROM_NAME;
		lc.USER_TYPE = result.USER_TYPE;
		lc.OMS_MASTER_ID = result.MASTER_ID;
		lc.MASTER_ID="ABC";
		System.out.println(lc);
		
		
		data2 = data2.replace("\"errCode\":\"2\"", "\"errCode\":\"0\"");
		logger.info(data2);
	}
	
	
	@Test
	public void testPartlyComplete() throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("workorderid", "");
		data.put("masterid", "");
		data.put("remark", "");
		data.put("phone", "");
		data.put("workorderid", "");
		data.put("workorderid", "");
		data.put("workorderid", "");
		
		StringBuffer sb = new StringBuffer();
		
		List<File> files = FileReadUtil.getFiles("d:\\image");
		for (File file : files) {
			String path = file.getAbsolutePath();
			String imageStr = ImageUtil.getImageStr(path);
			sb.append(imageStr)
			.append("|");
		}
		
		String images = sb.toString();
		
		String[] split = images.split("\\|");
		String aaa = "aa|bb|cc";
//		String[] split = aaa.split("\\|");
		for (int i=0;i<split.length;i++) {
			ImageUtil.generateImage(split[i], "d:\\image\\img\\10000"+i+".jpg");
		}
		
		//System.out.println(split.length);
		
		List<Goods> g = new ArrayList<Goods>();
//		for(int i=0;i<3;i++){
		Goods go = new Goods();
		go.GOOD_NO = "0000212941";
		go.GOOD_LINEID = 1+"";
		go.ITEM_AMOUNT = 1+"";
		go.ACTUAL_AMOUNT = 0+"";
		go.IS_COMPLETEED = "Y";
		go.UNCOM_REASON = "安装成功";
		go.REMARK = "安装成功";
		g.add(go);
		
//		Goods goo = new Goods();
//		goo.GOOD_NO = "0000226416";
//		goo.GOOD_LINEID = 2+"";
//		goo.ITEM_AMOUNT = 1+"";
//		goo.ACTUAL_AMOUNT = 0+"";
//		goo.IS_COMPLETEED = "Y";
//		goo.UNCOM_REASON = "安装成功";
//		goo.REMARK = "安装成功";
//		g.add(goo);
		
//		Goods gooo = new Goods();
//		gooo.GOOD_NO = "0000208253";
//		gooo.GOOD_LINEID = 3+"";
//		gooo.ITEM_AMOUNT = 1+"";
//		gooo.ACTUAL_AMOUNT = 0+"";
//		gooo.IS_COMPLETEED = "Y";
//		gooo.UNCOM_REASON = "安装成功";
//		gooo.REMARK = "安装成功";
//		g.add(gooo);
//		}
		
		WorkOrderPartlyCompletedRequest partly = new WorkOrderPartlyCompletedRequest();
		partly.workorderid = "DL201607022508";
		partly.masterid = "YAJ20160309A050101";
		partly.remark = "安装完成";
		partly.phone = "15012896007";
		partly.name = "天津箭卫河西店.AX昝力";
		partly.address = "天津市天津市辖区和平区金街庭院蒙古路112号1-1-902";
		partly.items = g;
		partly.image = aaa;
		
		Gson gson = new Gson();
		String json = gson.toJson(partly);
		
		logger.info(json);
//		String data2 = OmsConnectUtil.getData("appFinishReport", json);
//		logger.info(data2);
	}
	
	@Test
	public void testQR2() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("workOrderId", "DL201604212102");
		params.put("evalServiceComplete", "1");
		params.put("evalPhoneBack", "0");
		params.put("satisfaction1", "5");
		params.put("satisfaction2", "5");
		params.put("satisfaction3", "5");
		params.put("customerEval", "联调测试");
		Gson gson = new Gson();
		
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appRecVisitResult", params );
		
		logger.info(data);
	}
	
	
	/**
	 * 
	 * <p> Description: 工单列表</p>
	 * 
	 * @date 2016年6月28日 下午2:51:57
	 * @version 1.0
	 * @throws Exception
	 */
	@Test
	public void testWorkList() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("masterid", "YAJ20160309A016501");
		params.put("staus", 1);
		params.put("pageindex", 1);
		params.put("pagesize", 50);
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appQueryDispatchOrder", params );
		logger.info(data);
	}
	
	
	@Test
	public void testSearchWork() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("masterid", "YAJ20160707A901013");
		//DL2016081310003
		params.put("searchWords", "DL2016081310003");
		params.put("pageindex", 1);
		params.put("pagesize", 10);
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appQueryDispatchOrderVague", params );
		logger.info(data);
	}
	
	
	@Test
	public void testSearchWorkDetail() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("workorderid", "10598");
		params.put("masterid", "YAJ20160707A901013");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appQueryDispatchDetail", params );
		logger.info(data);
	}
	
	
	@Test
	public void testBooking() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("workorderid", "3338");
		params.put("masterid", "YAJ20160707A901013");
		params.put("linkman", "MrDuan");
		params.put("address", "北京市朝阳区，高和蓝峰大厦B座7层");
		params.put("phone", "13502074163");
		params.put("status", 0);
		params.put("reason", "");
		params.put("date", "");
		params.put("call", "是");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appBespokeDispatch", params );
		logger.info(data);
	}
	
	
	@Test
	public void giveupWork() throws Exception {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("workorderid", "3338");
		params.put("remark", "路程过远");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appRejectDispatch", params );
		logger.info(data);
		
	}
	
	@Test
	public void testSgin() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("workorderid", "3212");
		params.put("signerid", "YAJ20160309A050101");
		params.put("type", "2");
		params.put("lat", "28.1111111");
		params.put("lng", "25.2222222");
		params.put("code", "62606");
		params.put("address", "北京市朝阳区，高和蓝峰大厦B座7层");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appHomeSign", params );
		logger.info(data);
	}
	
	
	@Test
	public void testGetProvince() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("provinceid", "");
		params.put("cityid", "11101");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appGetGovernmentArea", params );
		logger.info(data);
	}
	
	
	/**
	 * 
	 * <p> Description: 注册验证码</p>
	 * 
	 * @date 2016年7月5日 下午11:24:04
	 * @version 1.0
	 * @throws Exception
	 */
	@Test
	public void testCheckCode() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", "13502074163");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appRegSendCodeToPhone", params );
		logger.info(data);
	}
	
	
	/**
	 * 
	 * <p> Description: 忘记密码</p>
	 * 
	 * @date 2016年7月5日 下午11:54:21
	 * @version 1.0
	 * @throws Exception
	 */
	@Test
	public void testFogetPass() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", "13502074163");
		params.put("code", "1234");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appRecVerificateCode", params );
		logger.info(data);
	}
	
	@Test
	public void testModifyPass() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", "13502074163");
		params.put("code", "1234");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appRecVerificateCode", params );
		logger.info(data);
	}
	
	/**
	 * 
	 * <p> Description: 发送验证码</p>
	 * 
	 * @date 2016年7月6日 上午1:10:33
	 * @version 1.0
	 * @throws Exception
	 */
	@Test
	public void sendCheckCode() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", "13502074163");
		params.put("code", "1234");
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData("appRecVerificateCode", params );
		logger.info(data);
	}
	
	@Test
	public void sendMsg() throws Exception {
		String url = Util.getProperty("smsurl");
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("mobile", "13502074163");
		msg.put("content", "您的验证码为："+"123456"+" 请勿告诉他人");
		String post = HttpXmlClient.post(url, msg);
		logger.info("短信发送结果：" + post);
	}
	
	/**
	 * 
	 * <p> Description: 结算</p>
	 * 
	 * @date 2016年7月6日 上午10:36:50
	 * @version 1.0
	 * @throws Exception
	 */
	@Test
	public void testDeal() throws Exception {
		Map<String ,Object> params=new HashMap<String ,Object>();
		params.put("masterid", "YAJ20160309A050101");
		params.put("startdate", "2016/06/01");
		params.put("enddate", "2016/07/20 12:12:12");
		params.put("pageIndex", "1");
		params.put("pagesize", "10");
		String methodName="appQueryAccounts";
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info(json);
		String data = OmsConnectUtil.getData(methodName, params);
		logger.info(data);
	}
	
	@Test
	public void testSub() throws Exception {
		String ab = "2016-07-07";
		System.out.println(ab);
		ab = ab.replace("-", "/");
		System.out.println(ab);
	}
	
	
	@Test
	public void testSendCheckCode() throws Exception {
		//保存验证码
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", "13502074163");
		String data = OmsConnectUtil.getData("appRegSendCodeToPhone", params);
		logger.info(data);
	}
	
	
}
