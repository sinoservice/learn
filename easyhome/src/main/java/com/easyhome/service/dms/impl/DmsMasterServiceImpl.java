package com.easyhome.service.dms.impl;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;

import com.easyhome.service.dms.DmsMasterservice;
import com.easyhome.utils.AliyunSMS;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.MD5;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.dms.EbSupplierPlaceModel;
import com.easyhome.vo.dms.EbTechnicianCapacityModel;
import com.easyhome.vo.dms.EbTechnicianModel;
import com.easyhome.vo.dms.MasterRequestParseBean;
import com.easyhome.vo.dms.ServiceAreaRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class DmsMasterServiceImpl implements DmsMasterservice {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DmsMasterServiceImpl.class);
	/**
	 * 静态变量response
	 */
	private static BaseResponse response = new BaseResponse();
	/**
	 * 静态常量gson
	 */
	private static final Gson gson = new Gson();

	@Override
	public BaseResponse login(String phone, String password) {
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");

			url = url + "master";

			Map<String, Object> params = new HashMap<>();
			params.put("phone", phone);
			params.put("password", MD5.MD5Encode(password).substring(8, 24));

			String data = gson.toJson(params);

			Map<String, String> par = new HashMap<>();
			par.put("method", "login");
			par.put("data", data);
			// 请求方法
			String post = HttpXmlClient.post(url, par);
			response = gson.fromJson(post, BaseResponse.class);

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			logger.error("服务器异常", e);
		}
		return response;
	}

	/**
	 * 添加工人
	 */
	public BaseResponse Register(HttpServletRequest request, EbTechnicianModel ebTechnicianModel) {
		// 技师主信息
		MasterRequestParseBean masterRequestParseBean = new MasterRequestParseBean();
		try {
			Date date = new Date();
			DateFormat dayDf = new SimpleDateFormat("yyyyMMdd");
			DateFormat timeDf = new SimpleDateFormat("HHmmss");

			String day = dayDf.format(date);
			String time = timeDf.format(date);

			// 自动生成的技师工号
			String masterCode = "YAJ";
			masterCode = masterCode + day + "A" + time;

			ebTechnicianModel.setEbteCode(masterCode);
			ebTechnicianModel.setEbteWorkNo(masterCode);

			// 密码默认123456 加密截取
			if (null == ebTechnicianModel.getEbtePassword()) {
				String passWord = MD5.MD5Encode("123456").substring(8, 24);
				ebTechnicianModel.setEbtePassword(passWord);

			} else {
				ebTechnicianModel.setEbtePassword(MD5.MD5Encode(ebTechnicianModel.getEbtePassword()).substring(8, 24));
			}
			// 默认审核状态 0
			ebTechnicianModel.setEbteReviewState(1L);

			// 设置默认的启用状态
			ebTechnicianModel.setEbteCertifiedState(1L);

			// 技师种类-工人
			ebTechnicianModel.setEbteProperties("3");

			// 服务区域
			String proviceName = "";
			String cityName = "";
			String townName = "";
			// 设置EbTechnicianModel到MasterRequestParseBean 中
			masterRequestParseBean.setEbTechnicianModel(ebTechnicianModel);
			// 设置服务区域
			List<EbSupplierPlaceModel> ebSupplierPlaceModels = new ArrayList<>();
			if(ebTechnicianModel.getEbteServiceArea() != null && !"".equals(ebTechnicianModel.getEbteServiceArea())){	
				String[] area = ebTechnicianModel.getEbteServiceArea().split(",");
				String provinceId = area[0];
				String cityId = area[1];
				String[] town  = Arrays.copyOfRange(area,2,area.length);
				proviceName = this.findPlaceByCode(provinceId) == null ? proviceName : this.findPlaceByCode(provinceId);
				cityName = this.findPlaceByCode(cityId) == null ? cityName : this.findPlaceByCode(cityId);
				for (String townId : town) {
					townName = this.findPlaceByCode(townId) == null ? cityName : this.findPlaceByCode(townId);
					ebTechnicianModel.setEbteServiceArea(proviceName + cityName + townName);
					// 设置服务区域
					EbSupplierPlaceModel ebSupplierPlaceModel = setSupplierPlaceModel(provinceId, cityId, townId, ebTechnicianModel.getEbteWorkNo(),
							proviceName, cityName, townName);
					ebSupplierPlaceModels.add(ebSupplierPlaceModel);					
				}
			}
			masterRequestParseBean.setEbSupplierPlaceModelList(ebSupplierPlaceModels);	
			// 设置服务能力
			if(ebTechnicianModel.getEbteWorkType() != null && !"".equals(ebTechnicianModel.getEbteWorkType())){
				List<EbTechnicianCapacityModel> etcmList = new ArrayList<>();
				String[] workType = ebTechnicianModel.getEbteWorkType().split(",");
				for (String w : workType) {
					EbTechnicianCapacityModel etcm = createCapacityModel(masterCode, w);
					etcmList.add(etcm);
				}
				masterRequestParseBean.setEbTechnicianCapacityModel(etcmList);
			}
			// 请求服务
			Gson gson = new Gson();
			String url = ResourcesUtil.getValue("config", "dmsurl");

			url = url + "master";
			String json = gson.toJson(masterRequestParseBean);

			Map<String, String> params = new HashMap<>();

			params.put("data", json);
			params.put("method", "saveWorker");
			String post = HttpXmlClient.post(url, params);
			response = gson.fromJson(post, BaseResponse.class);
			logger.info(post);

		} catch (BeansException e) {
			e.printStackTrace();
			logger.info("服务器异常", e);
		}

		return response;

	}

	private EbSupplierPlaceModel setSupplierPlaceModel(String province, String city, String town, String masterCode,
			String proviceName, String cityName, String townName) {
		EbSupplierPlaceModel ebSupplierPlaceModel = new EbSupplierPlaceModel();
		ebSupplierPlaceModel.setEbspEbssCode(masterCode);
		ebSupplierPlaceModel.setEbspType("PLACE_DISTRICT");
		ebSupplierPlaceModel.setEbspProvinceCode(province);
		ebSupplierPlaceModel.setEbspProvinceName(proviceName);
		ebSupplierPlaceModel.setEbspCityCode(city);
		ebSupplierPlaceModel.setEbspCityName(cityName);
		ebSupplierPlaceModel.setEbspCountyCode(town);
		ebSupplierPlaceModel.setEbspCountyName(townName);
		ebSupplierPlaceModel.setEbspSupplierType("TECHNICIAN");
		ebSupplierPlaceModel.setEbspRegionName(proviceName + "县服务区域");
		return ebSupplierPlaceModel;
	}

	/**
	 * 
	 * @Title: createCapacityModel
	 * @Description: TODO 设置服务能力-九大品类能力
	 * @param masterCode
	 *            技师编码
	 * @param w
	 *            服务能力code
	 * @return EbTechnicianCapacityModel
	 * @date 2017年6月7日 上午10:04:29
	 */
	private EbTechnicianCapacityModel createCapacityModel(String masterCode, String w) {
		EbTechnicianCapacityModel etcm = new EbTechnicianCapacityModel();

		// 默认是卫浴
		String ebtcEbmgCode = "10000";
		// 卫浴10000
		if (w.equals("1")) {
			ebtcEbmgCode = "10000";
			// 瓷砖10001
		} else if (w.equals("2")) {
			ebtcEbmgCode = "10001";
			// 吊顶70
		} else if (w.equals("3")) {
			ebtcEbmgCode = "70";
			// 壁纸30
		} else if (w.equals("4")) {
			ebtcEbmgCode = "30";
			// 灯具50
		} else if (w.equals("5")) {
			ebtcEbmgCode = "10004";
			// 橱柜40
		} else if (w.equals("6")) {
			ebtcEbmgCode = "40";
			// 地板60
		} else if (w.equals("7")) {
			ebtcEbmgCode = "60";
			// 木门90
		} else if (w.equals("8")) {
			ebtcEbmgCode = "90";
			// 家具80
		} else if (w.equals("9")) {
			ebtcEbmgCode = "80";
			// 其他10009
		} else if (w.equals("10")) {
			ebtcEbmgCode = "10009";
		}
		etcm.setEbtcEbmgCode(ebtcEbmgCode);
		etcm.setEbtcEbteCode(masterCode);
		etcm.setEbtcLevel("1");
		etcm.setCapacityType(1l);
		return etcm;
	}

	/**
	 * 
	 * <p>
	 * description: 通过城市code获取城市名称
	 * </p>
	 * 
	 * @param code
	 * @return
	 * @date 2016年10月12日 下午10:33:00
	 */
	private String findPlaceByCode(String code) {

		Gson gson = new Gson();

		try {

			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");

			url = url + "baseInfo";

			Map<String, Object> params = new HashMap<>();
			params.put("code", code);

			String data = gson.toJson(params);

			Map<String, String> par = new HashMap<>();
			par.put("method", "findPlaceByCode");
			par.put("data", data);

			// 请求方法
			String post = HttpXmlClient.post(url, par);

			BaseResponse br = gson.fromJson(post, BaseResponse.class);
			int returnCode = br.getReturnCode();
			if (returnCode == 200) {

				return (String) br.getData();
			}
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 忘记密码
	 */
	@Override
	public BaseResponse findPassWord(HttpServletRequest request, String phone, String passWord, int code) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();

		try {

			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "master";

			// 校验验证码
			HttpSession session = request.getSession();
			int captcha = (int) session.getAttribute("code");

			// 如果相等则可以修改
			if (code == captcha) {
				Map<String, Object> params = new HashMap<>();
				params.put("phone", phone);
				params.put("passWord", MD5.MD5Encode(passWord).substring(8, 24));
				String data = gson.toJson(params);
				Map<String, String> par = new HashMap<>();
				par.put("method", "findPassWord");
				par.put("data", data);
				String post = HttpXmlClient.post(url, par);

				// response赋值
				response = gson.fromJson(post, BaseResponse.class);
				if (response.getReturnCode() == 201) {
					response.setInfo("密码修改成功");
					logger.info("密码修改成功");
				} else {
					response.setInfo("密码修改失败");
					logger.info("密码修改失败");
				}

			} else {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("验证码有误");
				logger.info("验证码有误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("服务器异常", e);
		}
		return response;
	}

	/**
	 * 短信验证码
	 */

	@Override
	public BaseResponse findCaptcha(HttpServletRequest request, String phone) {

		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		try {

			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "master";
			Map<String, String> param = new HashMap<>();
			param.put("ebtePhoneNo", phone);
			String json = gson.toJson(param);
			Map<String, String> par = new HashMap<>();
			par.put("data", json);
			par.put("method", "findPhone");

			// 请求方法
			String string = HttpXmlClient.post(url, par);
			response = gson.fromJson(string, BaseResponse.class);
			//url = ResourcesUtil.getValue("config", "smsurl");
			if (response.getReturnCode() == 200) {
				// 生成6位数验证码
				int code = (int) ((Math.random() * 9 + 1) * 100000);
				//String content = "验证码:" + code + "," + "有效期为30分钟。";
				HttpSession session = request.getSession();
				session.setAttribute("code", code);
				/*
				Map<String, String> params = new HashMap<>();
				params.put("mobile", phone);
				params.put("content", content);
				String post = HttpXmlClient.post(url, params);
				*/
				String content = code+"";
				AliyunSMS.sendMsgToPhone(phone, "SMS_137416477", content);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setInfo("发送成功");
				response.setData(content);
			}
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			logger.error("服务器异常", e);
		}
		return response;
	}

	/**
	 * 修改密码
	 */
	@Override
	public BaseResponse updatePassWord(String phone, String passWord, String newPassWord) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		try {

			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "master";
			Map<String, String> params = new HashMap<>();
			params.put("phone", phone);
			params.put("passWord", passWord);
			params.put("newPassWord", newPassWord);

			// json解析
			String data = gson.toJson(params);
			Map<String, String> par = new HashMap<>();
			par.put("data", data);
			par.put("method", "updatePassWord");
			String post = HttpXmlClient.post(url, par);

			// response赋值
			response = gson.fromJson(post, BaseResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 查找服务范围
	 */
	@Override
	public BaseResponse findServiceArea(ServiceAreaRequest areaRequest) {
		Gson gson = new Gson();
		try {

			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "area";
			String ebplType = areaRequest.getEbplType();
			String ebplCode = areaRequest.getEbplCode();
			String ebplParentPmCode = areaRequest.getEbplParentPmCode();
			Map<String, String> params = new HashMap<>();
			params.put("ebplType", ebplType);
			params.put("ebplCode", ebplCode);
			params.put("ebplParentPmCode", ebplParentPmCode);

			// json转换
			String json = gson.toJson(params);
			Map<String, String> param = new HashMap<>();
			param.put("data", json);
			param.put("method", "findArea");

			// 请求方法
			String post = HttpXmlClient.post(url, param);

			// response赋值
			response = gson.fromJson(post, BaseResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("服务器异常", e);
		}
		return response;
	}

	/**
	 * 更新技师信息
	 */
	@Override
	public BaseResponse updateWorkerData(HttpServletRequest request, EbTechnicianModel ebTechnicianModel) {
		// 技师主信息
		MasterRequestParseBean masterRequestParseBean = new MasterRequestParseBean();
		try {
			// 服务区域
			String proviceName = "";
			String cityName = "";
			String townName = "";

			// 设置EbTechnicianModel到MasterRequestParseBean 中
			masterRequestParseBean.setEbTechnicianModel(ebTechnicianModel);
			// 设置服务区域
			List<EbSupplierPlaceModel> ebSupplierPlaceModels = new ArrayList<>();
			if(ebTechnicianModel.getEbteServiceArea() != null && !"".equals(ebTechnicianModel.getEbteServiceArea())){
				String[] area = ebTechnicianModel.getEbteServiceArea().split(",");
				String provinceId = area[0];
				String cityId = area[1];
				String[] town  = Arrays.copyOfRange(area,2,area.length);
				proviceName = this.findPlaceByCode(provinceId) == null ? proviceName : this.findPlaceByCode(provinceId);
				cityName = this.findPlaceByCode(cityId) == null ? cityName : this.findPlaceByCode(cityId);
				for (String townId : town) {
					townName = this.findPlaceByCode(townId) == null ? cityName : this.findPlaceByCode(townId);
					ebTechnicianModel.setEbteServiceArea(proviceName + cityName + townName);
					// 设置服务区域
					EbSupplierPlaceModel ebSupplierPlaceModel = setSupplierPlaceModel(provinceId, cityId, townId, ebTechnicianModel.getEbteWorkNo(),
							proviceName, cityName, townName);
					ebSupplierPlaceModels.add(ebSupplierPlaceModel);
						
				}
				masterRequestParseBean.setEbSupplierPlaceModelList(ebSupplierPlaceModels);
			}		
			if(ebTechnicianModel.getEbteWorkType() != null && !"".equals(ebTechnicianModel.getEbteWorkType())){
				// 设置服务能力
				List<EbTechnicianCapacityModel> etcmList = new ArrayList<>();
				String[] workType = ebTechnicianModel.getEbteWorkType().split(",");
				for (String w : workType) {
					EbTechnicianCapacityModel etcm = createCapacityModel(ebTechnicianModel.getEbteWorkNo(), w);
					etcmList.add(etcm);
				}
				masterRequestParseBean.setEbTechnicianCapacityModel(etcmList);	
			}


			// 请求服务
			Gson gson = new Gson();
			String url = ResourcesUtil.getValue("config", "dmsurl");

			url = url + "master";
			String json = gson.toJson(masterRequestParseBean);

			Map<String, String> params = new HashMap<>();

			params.put("data", json);
			params.put("method", "updateWorker");
			logger.info(params);
			String post = HttpXmlClient.post(url, params);
			response = gson.fromJson(post, BaseResponse.class);
			logger.info(post);

		} catch (BeansException e) {
			response.setInfo("数据库查询异常！");
			response.setReturnCode(ReturnCode.STATUS_500);
			logger.info("数据库查询异常！");
		}
		return response;
	}

}
