package com.easyhome.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;

import sun.misc.BASE64Decoder;

@RestController
@RequestMapping("/file")
public class FileUploadController {

	@RequestMapping(value = "/upload")
	public BaseResponse upload(String imgStr, String kilometer, HttpServletRequest request) {

		BaseResponse response = new BaseResponse();
		if (imgStr == null || kilometer == null) {
			response.setReturnCode(ReturnCode.STATUS_400);
			response.setInfo("公里数或图片不能为空");
			return response;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpg图片
			String imgFilePath = request.getSession().getServletContext().getRealPath("upload") + File.separator
					+ System.currentTimeMillis() + ".jpg";// 新生成的图片
			File f = new File(request.getSession().getServletContext().getRealPath("upload"));
			if (!f.exists()) {
				f.mkdirs();
			}

			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();

			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo(ReturnCode.OK);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常，请稍后再试");
			return response;
		}
	}
}