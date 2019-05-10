package com.easyhome.service.wechat.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.ByteArrayOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class HttpTool 
{
	/**
	 * 通过get获取http信息
	 * @param getUrl 访问的路径
	 * @return
	 */
	public static String httpGet(String getUrl)
	{
		BufferedReader reader = null;  
		String lines="";
		try 
		{
			URL url = new URL(getUrl);  
			URLConnection connection  =  url.openConnection();
	        connection.connect();
	        InputStreamReader in =new InputStreamReader(connection.getInputStream(),"UTF-8");
	        reader = new BufferedReader(in);    
	        String tempStr="";
	        while ((tempStr = reader.readLine()) != null) 
	        {
	        	lines+=tempStr;
	        }
	        reader.close();
	        in.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lines;
	}
	
	
	/**
	 * 通过get获取https信息
	 * @param getUrl 访问的路径
	 * @return
	 */
	public static String httpsGet(String getUrl) {
		BufferedReader reader = null;  
		HttpsURLConnection connection = null;
		String lines="";
		try {
			logger.error("---getUrl---"+getUrl);
			URL url = new URL(getUrl);
			logger.error("---url---"+url);
	        connection = (HttpsURLConnection) url.openConnection();
	        connection.setConnectTimeout(10000);//60秒超时设置
	        connection.setReadTimeout(10000);//60秒超时设置
	        connection.connect();
	        InputStreamReader in =new InputStreamReader(connection.getInputStream(),"UTF-8");
	        logger.error("---in---"+in);
	        reader = new BufferedReader(in);
	        String tempStr="";
	        logger.error(tempStr+"---while---"+reader);
	        while ((tempStr = reader.readLine()) != null) {
	        	lines+=tempStr;
	        	logger.error("---start===lines---"+lines);
	        }
	        in.close();
	        reader.close();
            connection.disconnect();
		} catch (Exception e) {
			logger.error(lines+"---exception1---"+e.getMessage());
			e.printStackTrace();
		}
		logger.error(lines+"---lines---end");
		return lines;
	}
	private static final Log logger = LogFactory.getLog(HttpTool.class);
	/**
	 * 通过post获取https信息
	 * @param postUrl 访问路径
	 * @param info post信息
	 * @return
	 */
	public static String httpsPost(String postUrl,String info)
	{
		BufferedReader reader = null;  
		HttpsURLConnection connection = null;
		String lines="";
		try 
		{
			URL url = new URL(postUrl);
			connection = (HttpsURLConnection) url.openConnection();  
            connection.setDoInput(true);  
            connection.setDoOutput(true);  
            connection.setRequestMethod("POST");  
            connection.setRequestProperty("Content-Length",String.valueOf(info.getBytes().length));  
            connection.setUseCaches(false);  
            connection.getOutputStream().write(info.getBytes("UTF-8"));
            connection.getOutputStream().flush();  
            connection.getOutputStream().close();  
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));  
            String tempStr="";  
            while ((tempStr = reader.readLine()) != null)
            {  
            	lines+=tempStr; 
            }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lines;
	}
	/**
	 * 通过post获取http信息
	 * @param postUrl 访问路径
	 * @param info post信息
	 * @return
	 */
	public static String httpPost(String postUrl,String info)
	{
		BufferedReader reader = null;  
		String lines="";
		try 
		{
			URL url = new URL(postUrl);
			URLConnection connection = url.openConnection();  
            connection.setDoInput(true);  
            connection.setDoOutput(true);  
            connection.setRequestProperty("Content-Length",String.valueOf(info.getBytes().length));  
            connection.setUseCaches(false);  
            connection.getOutputStream().write(info.getBytes("UTF-8"));
            connection.getOutputStream().flush();  
            connection.getOutputStream().close();  
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));  
            String tempStr="";  
            while ((tempStr = reader.readLine()) != null)
            {  
            	lines+=tempStr; 
            }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lines;
	}
	/**  
     * 从输入流中获取数据  
     * @param inStream 输入流  
     * @return  
     * @throws Exception  
     */    
    public static byte[] readInputStream(InputStream inStream) throws Exception{    
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();    
        byte[] buffer = new byte[1024];    
        int len = 0;    
        while( (len=inStream.read(buffer)) != -1 ){    
            outStream.write(buffer, 0, len);    
        }    
        inStream.close();
        return outStream.toByteArray();    
    }    
    
    /**  
     * 将图片写入到磁盘  
     * @param img 图片数据流  
     * @param fileName 文件保存时的名称  
     */    
    public static void writeImageToDisk(byte[] img, String fileName){    
        try {    
            File file = new File("D:\\" + fileName);    
            FileOutputStream fops = new FileOutputStream(file);    
            fops.write(img);    
            fops.flush();    
            fops.close();    
            System.out.println("图片已经写入到D盘");    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
    }    
}
