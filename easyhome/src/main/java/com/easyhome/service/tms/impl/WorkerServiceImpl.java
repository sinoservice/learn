package com.easyhome.service.tms.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.po.tms.WorkerComplete;
import com.easyhome.service.tms.WorkerServiceI;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

import sun.misc.BASE64Decoder;

@Service("workerService")
public class WorkerServiceImpl implements WorkerServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkerServiceImpl.class);

	@Override
	public String findWorkerList(String masterId, Integer pageIndex, Integer pageSize) {
		Gson gson = new Gson();
		String url = Util.getProperty("tmsurl")+"/worker/findWorkerList";
		BaseResponse br = new BaseResponse();
		try {
			// 设置参数
			Map<String, String> data = new HashMap<String, String>();
			data.put("masterId", masterId);
			data.put("pageIndex", pageIndex + "");
			data.put("pageSize", pageSize + "");
			// 请求网络
			String result = HttpXmlClient.post(url, data);
			return result;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(br);
	}

	@Override
	public String findWorkerDetails(String fid, String masterId) {
		Gson gson = new Gson();
		String url = Util.getProperty("tmsurl")+"/worker/findWorkerDetile";
		BaseResponse br = new BaseResponse();
		try {
			// 设置参数
			Map<String, String> data = new HashMap<String, String>();
			data.put("fid", fid);
			data.put("masterId", masterId);
			// 请求网络
			String result = HttpXmlClient.post(url, data);
			return result;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(br);
	}

	@Override
	/**
	 * 调用完善工人
	 */
	public String completeWorkerDetails(WorkerComplete workerComplete) {
		Gson gson = new Gson();
		String url = Util.getProperty("tmsurl")+"/worker/completeWorkerDetails";
		BaseResponse br = new BaseResponse();
		try {
			// 设置参数
			String img1 = workerComplete.getImages1();
			String img2 = workerComplete.getImages2();
			String img3 = workerComplete.getImages3();
			workerComplete.setImages1(saveImg(img1));
			workerComplete.setImages2(saveImg(img2));
			workerComplete.setImages3(saveImg(img3));
			Map<String, String> data = new HashMap<String, String>();
			data.put("masterId", workerComplete.getMasterId());
			data.put("fid", workerComplete.getFid());	
			data.put("name", workerComplete.getName());
			data.put("sex", workerComplete.getSex());
			data.put("phone", workerComplete.getPhone());
			data.put("age", workerComplete.getAge());
			data.put("chat",  workerComplete.getChat());
			data.put("identitycard",workerComplete.getIdentitycard());
			data.put("worktypes",workerComplete.getWorktypes());
			data.put("tools",workerComplete.getTools());
			data.put("insurance", workerComplete.getInsurance());
			data.put("bankname",  workerComplete.getBankname());
			data.put("branch",  workerComplete.getBranch());
			data.put("bankaccount",  workerComplete.getBankaccount());
			data.put("banknumber", workerComplete.getBanknumber());
			data.put("soslinkman", workerComplete.getSoslinkman());
			data.put("linkphone",  workerComplete.getLinkphone());
			data.put("relationship",  workerComplete.getRelationship());
			data.put("images1", workerComplete.getImages1());
			data.put("images2", workerComplete.getImages2());
			data.put("images3", workerComplete.getImages3());
			data.put("remark",  workerComplete.getRemark());
			data.put("provincename", workerComplete.getProvincename());
			data.put("cityname", workerComplete.getCityname());
			data.put("districtname",workerComplete.getDistrictname());
			// 请求网络
			logger.info("-----------------------让我看见错误好不好---------------------------------");
			logger.info(data);
			String result = HttpXmlClient.post(url, data);
			logger.info(result);
			return result;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常:完善工人信息异常：", e);
		}
		return gson.toJson(br);
	}
	
	private String saveImg(String imgStr) {

		String Basepath = Util.getProperty("filePath");
		BASE64Decoder decoder = new BASE64Decoder();
		Calendar c = Calendar.getInstance();
		String filePath = "upload" + File.separator + c.get(Calendar.YEAR) + File.separator + (c.get(Calendar.MONTH) + 1)
				+ File.separator + c.get(Calendar.DAY_OF_MONTH) + File.separator;
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
	public String lookOwnerData(String fid) {
		Gson gson = new Gson();
		String url = Util.getProperty("tmsurl")+"/worker/lookOwnerData";
		BaseResponse br = new BaseResponse();
		try {
			// 设置参数
			Map<String, String> data = new HashMap<String, String>();
			data.put("fid", fid);
			// 请求网络
			String result = HttpXmlClient.post(url, data);
			return result;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(br);
	}

	@Override
	public String add(String name, String phone, String passWord, String masterId) {
		Gson gson = new Gson();
		String url = Util.getProperty("tmsurl")+"/worker/add";
		BaseResponse br = new BaseResponse();
		try {
			// 设置参数
			Map<String, String> data = new HashMap<String, String>();
			data.put("name", name);
			data.put("phone", phone);
			data.put("passWord", passWord);
			data.put("masterId", masterId);
			// 请求网络
			String result = HttpXmlClient.post(url, data);
			return result;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(br);
	}
/**
 * 删除工人
 */
	@Override
	public String delete(String fid, String masterId) {
		Gson gson = new Gson();
		String url = Util.getProperty("tmsurl")+"/worker/delete";
		BaseResponse br = new BaseResponse();
		try {
			// 设置参数
			Map<String, String> data = new HashMap<String, String>();
			data.put("fid", fid);
			data.put("masterId", masterId);
			// 请求网络
			String result = HttpXmlClient.post(url, data);
			return result;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(br);
	}
/**
 * 修改工人锁定/解锁状态
 */
	@Override
	public String modifyLocking(String fid, String masterId, Integer locking) {
		Gson gson = new Gson();
		String url = Util.getProperty("tmsurl")+"/worker/modifyLocking";
		BaseResponse br = new BaseResponse();
		try {
			// 设置参数
			Map<String, String> data = new HashMap<String, String>();
			data.put("fid", fid);
			data.put("masterId", masterId);
			data.put("locking", locking==0?"0":"1");
			// 请求网络
			String result = HttpXmlClient.post(url, data);
			return result;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(br);
	}
/**
 * 修改工人信息
 */
	@Override
	public String modifyWorker(String name, String phone, String passWord, String fid) {
		Gson gson = new Gson();
		String url = Util.getProperty("tmsurl")+"/worker/modifyWorker";
		BaseResponse br = new BaseResponse();
		try {
			// 设置参数
			Map<String, String> data = new HashMap<String, String>();
			data.put("name", name);
			data.put("phone", phone);
			data.put("passWord", passWord);
			data.put("fid", fid);
			// 请求网络
			String result = HttpXmlClient.post(url, data);
			return result;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常：", e);
		}
		return gson.toJson(br);
	}
}
