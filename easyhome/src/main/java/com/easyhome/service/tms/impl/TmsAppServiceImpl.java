package com.easyhome.service.tms.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.service.tms.TmsAppServiceI;
import com.easyhome.utils.HttpClientUtil;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.TmsConnectUtil;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.TmsResponse;
import com.easyhome.vo.tms.RequestModel;
import com.easyhome.vo.tms.VersionVo;
import com.google.gson.Gson;

import sun.misc.BASE64Decoder;

/**
 * 
 * @ClassName: TmsAppServiceImpl
 * @Description: TODO tmsApp服务实现类
 * @date 2016年11月25日 下午3:27:51
 *
 */
@Service
public class TmsAppServiceImpl implements TmsAppServiceI {

	private static final Logger logger = Logger.getLogger(TmsAppServiceImpl.class);
	/**
	 * 配置文件名称
	 */
	public static final String CONFIG = "config";

	/**
	 * app最新版本
	 */
	public static final String VERSION_NO = "versionNo";

	/**
	 * app版本名称
	 */
	public static final String VERSION_NAME = "versionName";

	/**
	 * app版本描述
	 */
	public static final String VERSION_DESCRIPTION = "versionDescription";

	/**
	 * 下载地址
	 */
	public static final String DOWNLAOD_URL = "downlaodUrl";

	/**
	 * tms日志请求地址
	 */
	private static final String LOG_URL = "logIp";

	@Override
	public String checkAppVersion() throws Exception {

		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		try {

			// 读取app版本信息
			String version = ResourcesUtil.getValue(CONFIG, VERSION_NO);
			String versionName = ResourcesUtil.getValue(CONFIG, VERSION_NAME);
			String versionDescription = ResourcesUtil.getValue(CONFIG, VERSION_DESCRIPTION);
			String downLoadUrl = ResourcesUtil.getValue(CONFIG, DOWNLAOD_URL);
			VersionVo versionVo = new VersionVo(version, versionName, versionDescription, downLoadUrl);

			br.setData(versionVo);
			br.setReturnCode(ReturnCode.STATUS_200);
			br.setInfo("检查更新成功");
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("检查更新失败");
		}
		return gson.toJson(br);
	}

	@Override
	public String downloadApp() throws Exception {

		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		try {

			// 读取下载地址
			String downlaodUrl = ResourcesUtil.getValue(CONFIG, DOWNLAOD_URL);
			br.setInfo("获取下载地址成功");
			br.setReturnCode(ReturnCode.STATUS_200);
			br.setData(downlaodUrl);
		} catch (Exception e) {
			br.setInfo(e.getMessage());
			br.setReturnCode(ReturnCode.STATUS_500);
		}

		return gson.toJson(br);
	}

	/**
	 * 登录
	 */
	@Override
	public String login(String driverPhone, String password) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverPhone", driverPhone);
			params.put("password", password);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appTmsUserLogin", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 发送验证码
	@Override
	public String appSendVerificateCode(String driverPhone) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverPhone", driverPhone);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appSendVerificateCode", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 忘记密码接口
	@Override
	public String appForgetPassword(String driverPhone, String verificateCode, String newPassword) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverPhone", driverPhone);
			params.put("verificateCode", verificateCode);
			params.put("newPassword", newPassword);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appForgetPassword", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 最近发货发车列表
	@Override
	public String appGetRecentDispatchOrder(String driverCode, String driverPhone, int pageindex, int pagesize)
			throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);
			params.put("pageindex", pageindex);
			params.put("pagesize", pagesize);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appGetRecentDispatchOrder", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	/**
	 * 统计各类订单/运单数量
	 */
	@Override
	public String appGetMyDeliveryCensus(String driverCode, String driverPhone) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appGetMyDeliveryCensus", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 运单列表
	@Override
	public String appGetDispatchList(String driverCode, String driverPhone, String dispatchOrderNO,
			String isReservedSuccess, int pageindex, int pagesize) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);
			params.put("dispatchOrderNO", dispatchOrderNO);
			params.put("isReservedSuccess", isReservedSuccess);
			params.put("pageindex", pageindex);
			params.put("pagesize", pagesize);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appGetDispatchList", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 订单列表
	@Override
	public String appGetOrderList(String driverCode, String driverPhone, String dispatchOrderNo, String orderStatus)
			throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);
			params.put("dispatchOrderNo", dispatchOrderNo);
			params.put("orderStatus", orderStatus);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appGetOrderList", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 订单详情
	@Override
	public String appGetOrderDetail(String driverCode, String driverPhone, String dispatchOrderNo, String orderId)
			throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);
			params.put("dispatchOrderNo", dispatchOrderNo);
			params.put("orderId", orderId);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appGetOrderDetail", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 司机预约
	@Override
	public String appDispatchAppointTime(String orderId, String dispatchOrderNo, String driverCode,
			String reserveStatus, String reserveOpeName, String reserveTime, String reserveTimeDuring,
			String failReasonCode, String reserveRemark) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orderId", orderId);
			params.put("dispatchOrderNo", dispatchOrderNo);
			params.put("driverCode", driverCode);
			params.put("reserveStatus", reserveStatus);
			params.put("reserveOpeName", reserveOpeName);
			params.put("reserveTime", reserveTime);
			params.put("reserveTimeDuring", reserveTimeDuring);
			params.put("failReasonCode", failReasonCode);
			params.put("reserveRemark", reserveRemark);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appDispatchAppointTime", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 发车单是否继续配送
	@Override
	public String appContinueToDelivery(String dispatchOrderNo, String continueFlag, String driverCode,
			String driverPhone, String operateRemark) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dispatchOrderNo", dispatchOrderNo);
			params.put("continueFlag", continueFlag);
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);
			params.put("operateRemark", operateRemark);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appContinueToDelivery", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 到车确认/发车确认接口
	@Override
	public String appUpdateDispatchStatus(String dispatchOrderNo, String operateType, String driverCode,
			String driverPhone, String operateRemark) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dispatchOrderNo", dispatchOrderNo);
			params.put("operateType", operateType);
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);
			params.put("operateRemark", operateRemark);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appUpdateDispatchStatus", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 查询待签收/已签收/异常签收的订单列表
	@Override
	public String appGetDispatchReceipt(String driverCode, String driverPhone, String receiptType, int pageindex,
			int pagesize) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);
			params.put("receiptType", receiptType);
			params.put("pageindex", pageindex);
			params.put("pagesize", pagesize);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appGetDispatchReceipt", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 订单签收/整单拒收/部分签收
	@Override
	public String appOrderSign(String requestJson) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			String data = TmsConnectUtil.getData("appOrderSign", requestJson);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 签收/异常签收详情
	@Override
	public String appGetReceiptDetail(String driverCode, String driverPhone, String receiptOrderId) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("driverCode", driverCode);
			params.put("driverPhone", driverPhone);
			params.put("receiptOrderId", receiptOrderId);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appGetReceiptDetail", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 数据字典
	@Override
	public String appGetDataDictionary(String dataType) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dataType", dataType);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appGetDataDictionary", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	// 16.发车单下订单统计
	@Override
	public String appDispatchOrderCount(String dispatchOrderNo, String driverCode) throws Exception {
		TmsResponse tr = new TmsResponse();
		Gson gson = new Gson();
		try {

			// 将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("dispatchOrderNo", dispatchOrderNo);
			params.put("driverCode", driverCode);

			// 发送请求参数，返回data(json格式)数据串
			String data = TmsConnectUtil.getData("appDispatchOrderCount", params);

			// 判断数据是否为空
			if (data == null || "".equals(data)) {
				tr.setRetCode(-1);
				tr.setRetMessage("获取数据失败！");
				return data;
			} else {

				// 登录成功，返回数据。
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			tr.setRetCode(ReturnCode.STATUS_500);
			tr.setRetMessage("服务器异常！");
			return gson.toJson(tr);
		}
	}

	/**
	 * 
	 * @Title: testImgQuality
	 * @Description: TODO
	 * @param @param
	 *            img 图片存储测试实现类
	 * @param @return
	 * @param @throws
	 *            Exception
	 * @return String
	 * @date 2016年12月2日 下午5:52:49
	 */
	@Override
	public String testImgQuality(String img) throws Exception {
		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		try {
			if (img != null && !"".equals(img)) {
				saveImg(img);
				br.setInfo("图片存储成功!");
				br.setReturnCode(ReturnCode.STATUS_200);
			} else {
				br.setInfo("参数不能为空");
				br.setReturnCode(ReturnCode.STATUS_400);
			}
		} catch (Exception e) {
			br.setInfo("服务器异常！");
			br.setReturnCode(ReturnCode.STATUS_500);
		}
		return gson.toJson(br);
	}

	private String saveImg(String imgStr) {
		String Basepath = Util.getProperty("filePath");
		BASE64Decoder decoder = new BASE64Decoder();
		Calendar c = Calendar.getInstance();
		String filePath = "upload" + File.separator + c.get(Calendar.YEAR) + File.separator
				+ (c.get(Calendar.MONTH) + 1) + File.separator + c.get(Calendar.DAY_OF_MONTH) + File.separator;
		System.out.println(filePath);
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}

			File f = new File(Basepath + filePath);
			if (!f.exists()) {
				f.mkdirs();
			}
			// 生成jpeg图片
			String imgFilePath = Basepath + filePath + System.currentTimeMillis() + ".jpg";// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.error("保存图片异常", e);
		}
		return filePath + System.currentTimeMillis() + ".jpg";
	}

	@Override
	public String getCountByMaster(String masterId, String version) throws Exception {
		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		String newestVersion = ResourcesUtil.getValue("config", "newestVersion");
		Double versionNow = Double.parseDouble(newestVersion);// 当前版本号
		Double versionPass = 0.0;
		if (version == null || "".equals(version)) {
			br.setInfo("当前版本较低,请更新版本！");
			br.setReturnCode(500);
			gson.toJson(br);
		} else {
			versionPass = Double.parseDouble(version);// 传入版本号
		}
		if (versionPass >= versionNow) {
			try {

				// 获取请求路径
				String path = ResourcesUtil.getValue("config", "warnningIp");
				String url = path + "services/AppWlSignSubWarning/getCountByType/";

				// 传递参数
				Map<String, String> params = new HashMap<>();
				params.put("masterId", masterId);
				String json = gson.toJson(params);

				// 发送请求
				String post = HttpClientUtil.postJson(url, json);
				return post;
			} catch (Exception e) { // 异常处理
				br.setReturnCode(ReturnCode.STATUS_500);
				br.setInfo("服务器异常");
				return gson.toJson(br);
			}
		} else {
			return gson.toJson(br);
		}
	}

	@Override
	public String queryWarnningRecord(String masterId, String type, int startIndex, int pageSize, String version)
			throws Exception {
		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		String newestVersion = ResourcesUtil.getValue("config", "newestVersion");
		Double versionNow = Double.parseDouble(newestVersion);// 当前版本号
		Double versionPass=0.0;
		if(version == null || "".equals(version)){
			br.setInfo("当前版本较低,请更新版本！");
			br.setReturnCode(500);
		}else{
			 versionPass = Double.parseDouble(version);//传入版本号
		}
		if (versionPass >= versionNow) {
			try {

				// 获取请求路径
				String path = ResourcesUtil.getValue("config", "warnningIp");
				String url = path + "services/AppWlSignSubWarning/queryPageList/";

				// 传递参数
				Map<String, Object> params = new HashMap<>();
				params.put("masterId", masterId);
				params.put("type", type);
				params.put("startIndex", startIndex);
				params.put("pageSize", pageSize);
				String json = gson.toJson(params);

				// 发送请求
				String post = HttpClientUtil.postJson(url, json);
				return post;
			} catch (Exception e) { // 异常处理

				br.setReturnCode(ReturnCode.STATUS_500);
				br.setInfo("服务器异常");
				return gson.toJson(br);
			}
		} else {
			br.setInfo("当前版本较低,请更新版本！");
			br.setReturnCode(500);
		}
		return gson.toJson(br);
	}

	@Override
	public String queryWarnningNotice(String masterId) throws Exception {

		Gson gson = new Gson();

		try {

			// 获取请求路径
			String path = ResourcesUtil.getValue("config", "warnningIp");
			String url = path + "services/AppWlSignSubWarning/indexWlRemind/";

			// 传递参数
			Map<String, Object> params = new HashMap<>();
			params.put("masterId", masterId);
			String json = gson.toJson(params);

			// 发送请求
			String post = HttpClientUtil.postJson(url, json);
			return post;
		} catch (Exception e) { // 异常处理
			BaseResponse br = new BaseResponse();
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("服务器异常");
			return gson.toJson(br);
		}
	}

	@Override
	public String warnningRemove(String masterId, String flag) throws Exception {

		Gson gson = new Gson();

		try {

			// 获取请求路径
			String path = ResourcesUtil.getValue("config", "warnningIp");
			String url = path + "services/AppWlSignSubWarning/delIndexWlRemind/";

			// 传递参数
			Map<String, Object> params = new HashMap<>();
			params.put("masterId", masterId);
			params.put("flag", flag);
			String json = gson.toJson(params);

			// 发送请求
			String post = HttpClientUtil.postJson(url, json);
			return post;
		} catch (Exception e) { // 异常处理
			BaseResponse br = new BaseResponse();
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("服务器异常");
			return gson.toJson(br);
		}
	}

	@Override
	public String saveLogs(RequestModel model) {
		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		try {
			// 获取请求路径
			String path = ResourcesUtil.getValue(CONFIG, LOG_URL);
			String logUrl = path + "/logms/log/save";

			// 2.设置请求参数
			String data = gson.toJson(model);
			// System.out.println(data);
			String post = HttpClientUtil.postJson(logUrl, data);

			System.out.println("++++++++++++++++++++++请求成功===================");
			if (post == null || "".equals(post)) {
				br.setInfo("请求错误,连接异常");
				br.setReturnCode(ReturnCode.STATUS_500);
			} else {
				br.setData(post);
				br.setInfo("请求成功");
				br.setReturnCode(ReturnCode.STATUS_200);
			}
		} catch (Exception e) {
			br.setInfo("服务器异常");
			br.setReturnCode(ReturnCode.STATUS_500);
		}
		return gson.toJson(br);
	}

}
