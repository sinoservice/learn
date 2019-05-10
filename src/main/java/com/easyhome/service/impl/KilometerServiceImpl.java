package com.easyhome.service.impl;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyhome.dao.KilometerDao;
import com.easyhome.service.KilometerService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;

import sun.misc.BASE64Decoder;

@Service("/kilometerService")
public class KilometerServiceImpl implements KilometerService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(KilometerServiceImpl.class);

	@Resource
	private KilometerDao kilometerDao ;
	@Override
	public BaseResponse saveStart(String driverNo, String driverId, double startKilometer,String startUrl) {
		BaseResponse response=new BaseResponse();
		UUID uuid=UUID.randomUUID();
		String fid=UUID.randomUUID().toString();
		String Url=saveImg(startUrl);
		try {
			kilometerDao.addStart(fid, driverNo, driverId, startKilometer, Url);
			response.setReturnCode(ReturnCode.STATUS_201);
			response.setInfo("上传成功");
			logger.info("上传成功");
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("网络不给力，请稍后重试");
			logger.error("获取数据异常",e);
		}
		
		return response;
	}

	@Override
	public BaseResponse saveEnd(double endKilometer, String endUrl) {
		BaseResponse response=new BaseResponse();
		String Url=saveImg(endUrl);
		try {
			kilometerDao.addEnd(endKilometer, Url);
			response.setReturnCode(ReturnCode.STATUS_201);
			response.setInfo("上传成功");
			logger.info("上传成功");
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("网络不给力，请稍后重试");
			logger.error("获取数据异常",e);
		}
		return response;
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

}
