package com.easyhome.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p> Title: FileReadUtil</p>
 * <p> Description: 文件读取工具类</p>
 * 
 * @date 2016年7月1日 上午11:55:28
 * @version 1.0
 *
 */
public class FileReadUtil {

	/**
	 * 
	 * <p> Description: </p>
	 * 
	 * @date 2016年7月1日 上午11:38:09
	 * @version 1.0
	 * @param path
	 * @return
	 */
	public static List<File> getFiles(String path) throws Exception{
		List<File> files = new ArrayList<File>();
		File file=new File(path);
		File[] tempList = file.listFiles();
		
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {//文件
				files.add(tempList[i]);
			}
			if (tempList[i].isDirectory()) {//文件夹
				
			}
		}
		return files;
	}
	
}
