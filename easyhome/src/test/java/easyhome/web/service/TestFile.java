package easyhome.web.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.easyhome.utils.FileReadUtil;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ImageUtil;
import com.easyhome.utils.MD5;

public class TestFile {

	@Test
	public void testRead() throws Exception {
		String path="d:\\image";
		  File file=new File(path);
		  File[] tempList = file.listFiles();
		  System.out.println("该目录下对象个数："+tempList.length);
		  for (int i = 0; i < tempList.length; i++) {
		   if (tempList[i].isFile()) {
		    System.out.println("文     件："+tempList[i]);
		   }
		   if (tempList[i].isDirectory()) {
		    System.out.println("文件夹："+tempList[i]);
		   }
		  }
	}
	
	@Test
	public void testReadUtil() throws Exception {
		List<File> files = FileReadUtil.getFiles("d:\\image");
	}
	
	@Test
	public void testGetImageStr() throws Exception {
		String path = "d:\\image\\01.jpg";
		String str = ImageUtil.getImageStr(path);
		System.out.println(str);
		
		boolean generateImage = ImageUtil.generateImage(str, "d:\\image\\img\\11.jpg");
		System.out.println(generateImage);
	}
	
	@Test
	public void testGetImageStrs() throws Exception {
		StringBuffer sb = new StringBuffer();
		
		List<File> files = FileReadUtil.getFiles("d:\\image");
		for (File file : files) {
			String path = file.getAbsolutePath();
			String imageStr = ImageUtil.getImageStr(path);
			sb.append(imageStr)
			.append("|");
		}
		
		String images = sb.toString();
		String[] split = images.split("|");
		System.out.println(split.length);
		//System.out.println(images);
	}
	
	@Test
	public void testPwd() throws Exception {
		String pwd = "70787028";
		System.out.println(MD5.MD5Encode(pwd).toUpperCase());
	}
	
	@Test
	public void testHttpAppend() throws Exception {
		String url = "http://192.16.8.8:8088/eaju_app_service/oms/user/Login?phone=13502074163&password=123456";
		//String string = HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
		//System.out.println(string);
		
		String url2 = "http://192.16.8.8:8088/eaju_app_service/oms/user/Login";
		Map<String, String> params = new HashMap<>();
		params.put("phone", "13502074163");
		params.put("password", "123456");
		String post = HttpXmlClient.post(url2, params);
		System.out.println(post);
	}
}
