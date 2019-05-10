package com.easyhome.service.wechat.utils;

import com.easyhome.utils.EmptyUtils;

import net.sf.json.JSONObject;

public class AccessToken {
	
	private static boolean isRunning = false;//运行标识
	private static String accesstoken="";//票据信息
	private static long getTime;//获取的时间
	private static String expiresin;//有效时间 秒
	public static String getAccessToken() {
		if (isRunning) {
			return accesstoken;
		}
		isRunning = true;
		try {
			//如果有值且没超时，直接return
			if(EmptyUtils.isNotEmpty(accesstoken) &&  Long.valueOf(expiresin)>(System.currentTimeMillis()-getTime)/1000){
				System.out.println("---有值且没超时---"+accesstoken);
				return accesstoken;
			}
			//首先判断时间是否超时,或则accesstoken为空
			if(EmptyUtils.isEmpty(accesstoken) ||  Long.valueOf(expiresin)<(System.currentTimeMillis()-getTime)/1000) {
					//防止并发混入
					System.out.println("---防止并发混入---"+accesstoken+"---防止并发混入---"+expiresin+"---防止并发混入---"+(System.currentTimeMillis()-getTime)/1000);
					if(EmptyUtils.isEmpty(accesstoken) ||  Long.valueOf(expiresin)<(System.currentTimeMillis()-getTime)/1000) {
						//去微信获取accessToken
						String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",ConstantsWeChat.APPID,ConstantsWeChat.SECERT);
						JSONObject result = JSONObject.fromObject(HttpTool.httpsGet(url));
						if(result.containsKey("errcode")) {
							System.out.println(result.getString("errmsg"));
							return "";
						} else {
							accesstoken=result.getString("access_token");
							getTime=System.currentTimeMillis();
							expiresin=result.getString("expires_in");
						}
						System.out.println(result+"---微信获取accessToken---"+accesstoken+"---微信获取accessToken---"+expiresin+"---微信获取accessToken---"+getTime/1000);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {
			isRunning = false;
		}
		return accesstoken;
	}
	public static void main(String[] args) {
		getAccessToken();
	}
}
