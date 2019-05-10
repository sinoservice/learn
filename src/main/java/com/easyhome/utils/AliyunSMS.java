package com.easyhome.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class AliyunSMS {
	
	public static String sendMsgToPhone(final String phone,final String template, String content) {
        //产品名称:云通信短信API产品,开发者无需替换
        final String product = "Dysmsapi";
        //产品域名,开发者无需替换
        final String domain = "dysmsapi.aliyuncs.com";

        //此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
        final String accessKeyId = "LTAIJkbX0hV5ooax";
        final String accessKeySecret = "pFgGhzsAG3t3IeidUdJONfKn0CEtqF";
    	final String signName = "居然到家";
        
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        String returnMsg = "";
        try {
	        //初始化acsClient,暂不支持region化
	        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
	        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
	        IAcsClient acsClient = new DefaultAcsClient(profile);
	        //组装请求对象-具体描述见控制台-文档部分内容
	        SendSmsRequest request = new SendSmsRequest();
	        //必填:待发送手机号
	        request.setPhoneNumbers(phone);
	        //必填:短信签名-可在短信控制台中找到
	        request.setSignName(signName);
	        //必填:短信模板-可在短信控制台中找到
	        request.setTemplateCode(template);
	        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
	        //request.setTemplateParam("{\"name\":\"居然之家消费者\"}");
	        request.setTemplateParam(generateContent(template,content));
	        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
	        //request.setSmsUpExtendCode("90997");
	        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
	        request.setOutId("yourOutId");
	        //hint 此处可能会抛出异常，注意catch
	        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
	        System.out.println("bizId---"+sendSmsResponse.getBizId()+"---result---"+sendSmsResponse.getMessage());
	        returnMsg = sendSmsResponse.getCode();
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return returnMsg;
    }
    
    private static String generateContent(String template,String content) {
    	String msgContent = null;
    	String[] params = content.split("@"); 
    	if(template.equals("SMS_137421430")) {
    		//请您妥善保存服务确认码 ${code},并在服务完成后提供给安装师傅。
    		msgContent = "{\"code\":\""+params[0]+"\"}";
    	}else if(template.equals("SMS_137421474")) {
    		//您好,您本次注册的验证码为${code},请勿泄漏于他人。
    		msgContent = "{\"code\":\""+params[0]+"\"}";
    	}else if(template.equals("SMS_137426529")) {
    		//尊敬的${customer}客户您好,您的订单${order}已服务完毕并完成服务评价,祝您生活愉快!
    		msgContent = "{\"customer\":\""+params[0]+"\", \"order\":\""+params[1]+"\"}";
    	}else if(template.equals("SMS_137416477")) {
    		//您的验证码为:${code},该验证码30分钟内有效,请勿泄漏于他人。
    		msgContent = "{\"code\":\""+params[0]+"\"}";

    	}else if(template.equals("SMS_139234592")) {
    		//您的验证码为:${code},该验证码30分钟内有效,请勿泄漏于他人。
    		msgContent = "{\"code\":\""+params[0]+"\"}";
    	}else if(template.equals("SMS_139229577")) {
    		//您的验证码为:${code},该验证码2分钟内有效,请勿泄漏于他人。
    		msgContent = "{\"code\":\""+params[0]+"\"}";
    	}

    	return msgContent;
    }

}
