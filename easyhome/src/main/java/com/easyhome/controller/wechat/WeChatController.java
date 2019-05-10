package com.easyhome.controller.wechat;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.controller.wechat.entity.Articles;
import com.easyhome.controller.wechat.entity.ArticlesItem;
import com.easyhome.controller.wechat.entity.Music;
import com.easyhome.controller.wechat.entity.ReplyMusicMessage;
import com.easyhome.controller.wechat.entity.ReplyTextMessage;
import com.easyhome.controller.wechat.entity.ReplyTuwenMessage;
import com.easyhome.controller.wechat.entity.RequestTextMessage;
import com.easyhome.po.wechat.EvaluationRequestBean;
import com.easyhome.po.wechat.OrderDetailListRequestBean;
import com.easyhome.po.wechat.OrderListRequestBean;
import com.easyhome.po.wechat.PushRecordListRequestBean;
import com.easyhome.po.wechat.UserBean;
import com.easyhome.po.wechat.WeChatAppointmentBean;
import com.easyhome.service.wechat.service.DmsWeChatService;
import com.easyhome.service.wechat.utils.SignUtil;
import com.easyhome.vo.wechat.WeChatResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@RestController
@RequestMapping("/weChat")
public class WeChatController {

	@Autowired
	private DmsWeChatService dmsWeChatService;

	/**
	 * 发送短信验证
	 */
	@RequestMapping("/sendPhoneMsg")
	@ResponseBody
	public WeChatResponse sendPhoneMsg(String phone,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse weChatResponse=dmsWeChatService.sendPhoneMsg(phone,request);
		return weChatResponse;
	}

	/**
	 * 短信验证，手机绑定接口
	 */
	@RequestMapping("/weChatbinding")
	@ResponseBody
	public WeChatResponse weChatbinding(UserBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse weChatResponse=dmsWeChatService.weChatbinding(bean,request);
		return weChatResponse;
	}

	/**
	 * 登录
	 */
	@RequestMapping("/weChatLogin")
	@ResponseBody
	public WeChatResponse weChatLogin(UserBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse userResponse=dmsWeChatService.weChatLogin(bean,request,response);
		return userResponse;
	}


	/**
	 * url绑定
	 * @throws IOException 
	 */
	@RequestMapping("/weChatUrl")
	@ResponseBody
	public void weChatLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		SignUtil signUtil = new SignUtil();
		if(echostr == null){
			this.weixinChat(request, response);
		}else{
			// 验证微信凭证
			if (signature != null&& signUtil.checkSignature(signature, timestamp, nonce)) {
				try {
					PrintWriter pw = response.getWriter();
					pw.write(echostr);
					pw.flush();
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 订单查询接口
	 */
	@RequestMapping("/orderQuery")
	@ResponseBody
	public WeChatResponse orderQuery(OrderListRequestBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse userResponse=dmsWeChatService.orderQuery(bean,request,response);
		return userResponse;
	}
	
	/**
	 * 订单查询详情接口
	 */
	@RequestMapping("/orderQueryDetails")
	@ResponseBody
	public WeChatResponse orderQueryDetails(OrderDetailListRequestBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse userResponse=dmsWeChatService.orderQueryDetails(bean,request,response);
		return userResponse;
	}
	
	/**
	 * 订单状态节点查询接口
	 */
	@RequestMapping("/rderQueryNode")
	@ResponseBody
	public WeChatResponse rderQueryNode(OrderDetailListRequestBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse userResponse=dmsWeChatService.rderQueryNode(bean,request,response);
		return userResponse;
	}
	/**
	 * 查询推送记录接口
	 */
	@RequestMapping("/pushRecord")
	@ResponseBody
	public WeChatResponse pushRecord(PushRecordListRequestBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse userResponse=dmsWeChatService.pushRecord(bean,request,response);
		return userResponse;
	}
	
	/**
	 * 查询推送记录接口
	 */
	@RequestMapping("/orderQueryDetailsPhsu")
	@ResponseBody
	public WeChatResponse orderQueryDetailsPhsu(OrderDetailListRequestBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse userResponse=dmsWeChatService.orderQueryDetailsPhsu(bean,request,response);
		return userResponse;
	}
	
	/**
	 * 预约上门
	 */
	@RequestMapping("/appointment")
	@ResponseBody
	public WeChatResponse weChatAppointment(WeChatAppointmentBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse userResponse=dmsWeChatService.weChatAppointment(bean,request,response);
		return userResponse;
	}
	
	/**
	 * 服务评价
	 */
	@RequestMapping("/evaluation")
	@ResponseBody
	public WeChatResponse weChatEvaluation(EvaluationRequestBean bean,HttpServletRequest request,HttpServletResponse response){
		WeChatResponse userResponse=dmsWeChatService.weChatEvaluation(bean,request,response);
		return userResponse;
	}
	
	/**
	 * 自动回复
	 * @throws IOException 
	 */
//	@RequestMapping("/weixinChat")
//	@ResponseBody
	public void weixinChat(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String wxMsgXml = IOUtils.toString(request.getInputStream(), "utf-8");
		RequestTextMessage textMsg = null;
		try {
			textMsg = getRequestTextMessage(wxMsgXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer replyMsg = new StringBuffer();
		String receive = textMsg.getContent().trim();
		String returnXml = null;

		if (textMsg != null && !receive.equals("")) {
			if (receive.equals("？") || receive.equals("?")) {

				replyMsg.append("欢迎使用微信平台！");
				replyMsg.append("\r\n1、<a href='wtai//wp//mc;10086'>拨打10086 </a>");
				replyMsg.append("\r\n2、听音乐");
				replyMsg.append("\r\n3、看图文");
				replyMsg.append("\r\n其他、回音壁请直接输入文字信息");

				returnXml = getReplyTextMessage(replyMsg.toString(),
						textMsg.getFromUserName(), textMsg.getToUserName());

			} else if (receive.equals("2")) {

				// 回复音乐信息
				returnXml = getReplyMusicMessage(textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else if (receive.equals("3")) {

				// 回复图文
				returnXml = getReplyTuwenMessage(textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else if (receive.equals("1")) {
				// 回复时间
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");

				replyMsg.append("当前时间\r\n" + df.format(new Date()));
				returnXml = getReplyTextMessage(replyMsg.toString(),
						textMsg.getFromUserName(), textMsg.getToUserName());

			} else {

				replyMsg.append("收到： " + textMsg.getContent());
				returnXml = getReplyTransferMessage(replyMsg.toString(),
						textMsg.getFromUserName(), textMsg.getToUserName());

			}
		} else {

			replyMsg.append("别闹了，这谁看得懂啊！");
			returnXml = getReplyTextMessage(replyMsg.toString(),
					textMsg.getFromUserName(), textMsg.getToUserName());

		}
		pw.println(returnXml);
		pw.flush();
		pw.close();
	}
	
		// 获取推送文本消息
		private RequestTextMessage getRequestTextMessage(String xml) {

			XStream xstream = new XStream(new DomDriver());

			xstream.alias("xml", RequestTextMessage.class);
			xstream.aliasField("ToUserName", RequestTextMessage.class, "toUserName");
			xstream.aliasField("FromUserName", RequestTextMessage.class,
					"fromUserName");
			xstream.aliasField("CreateTime", RequestTextMessage.class, "createTime");
			xstream.aliasField("MsgType", RequestTextMessage.class, "messageType");
			xstream.aliasField("Content", RequestTextMessage.class, "content");
			xstream.aliasField("MsgId", RequestTextMessage.class, "msgId");

			RequestTextMessage requestTextMessage = (RequestTextMessage) xstream
					.fromXML(xml);
			return requestTextMessage;

		}
		
		 //    回复文本消息
	     private String getReplyTextMessage(String content, String fromUserName,String toUserName){
	         
	         ReplyTextMessage we = new ReplyTextMessage();
	         we.setMessageType("text");
	         we.setFuncFlag("0");
	         we.setCreateTime(new Long(new Date().getTime()).toString());
	         we.setContent(content);
	         we.setToUserName(fromUserName);  
	         we.setFromUserName(toUserName);
	         XStream xstream = new XStream(new DomDriver()); 
	         xstream.alias("xml", ReplyTextMessage.class);
	         xstream.aliasField("ToUserName", ReplyTextMessage.class, "toUserName");
	         xstream.aliasField("FromUserName", ReplyTextMessage.class, "fromUserName");
	         xstream.aliasField("CreateTime", ReplyTextMessage.class, "createTime");
	         xstream.aliasField("MsgType", ReplyTextMessage.class, "messageType");
	         xstream.aliasField("Content", ReplyTextMessage.class, "content");
	         xstream.aliasField("FuncFlag", ReplyTextMessage.class, "funcFlag");
	         String xml =xstream.toXML(we);
	         return xml;
	     }
	     
	     //    回复自动接入
	     private String getReplyTransferMessage(String content, String fromUserName,String toUserName){
	         
	         ReplyTextMessage we = new ReplyTextMessage();
	         we.setMessageType("transfer_customer_service");
	         we.setFuncFlag("0");
	         we.setCreateTime(new Long(new Date().getTime()).toString());
	         we.setContent(content);
	         we.setToUserName(fromUserName);  
	         we.setFromUserName(toUserName);
	         XStream xstream = new XStream(new DomDriver()); 
	         xstream.alias("xml", ReplyTextMessage.class);
	         xstream.aliasField("ToUserName", ReplyTextMessage.class, "toUserName");
	         xstream.aliasField("FromUserName", ReplyTextMessage.class, "fromUserName");
	         xstream.aliasField("CreateTime", ReplyTextMessage.class, "createTime");
	         xstream.aliasField("MsgType", ReplyTextMessage.class, "messageType");
	         xstream.aliasField("Content", ReplyTextMessage.class, "content");
	         xstream.aliasField("FuncFlag", ReplyTextMessage.class, "funcFlag");
	         String xml =xstream.toXML(we);
	         return xml;
	     }
		 //    回复音乐消息
	     private String getReplyMusicMessage(String fromUserName,String toUserName){
	            
	             ReplyMusicMessage we = new ReplyMusicMessage();
	             Music music = new Music();
	             
	             we.setMessageType("music");
	             we.setCreateTime(new Long(new Date().getTime()).toString());
	             we.setToUserName(fromUserName);  
	             we.setFromUserName(toUserName);
	             we.setFuncFlag("0");
	             
	             music.setTitle("回家|X-man");
	             music.setDescription("萨克斯 回家  勾起你想家的愁思...");
	             
	             String url = "http://bcs.duapp.com/yishi-music/%E5%9B%9E%E5%AE%B6.mp3?sign=MBO:97068c69ccb2ab230a497c59d528dcce:LdYZ%2FLXohKa6YCy9gbxL%2B1mZ4Co%3D";
	             String url2 = "http://bcs.duapp.com/yishi-music/X-man.mp3?sign=MBO:97068c69ccb2ab230a497c59d528dcce:cYV%2B%2Fq2Tlv2de6gqecZynCyIm3k%3D";
	             music.setMusicUrl(url);
	             music.setHqMusicUrl(url2);
	             
	             we.setMusic(music);
	             
	             XStream xstream = new XStream(new DomDriver()); 
	             xstream.alias("xml", ReplyMusicMessage.class);
	             xstream.aliasField("ToUserName", ReplyMusicMessage.class, "toUserName");
	             xstream.aliasField("FromUserName", ReplyMusicMessage.class, "fromUserName");
	             xstream.aliasField("CreateTime", ReplyMusicMessage.class, "createTime");
	             xstream.aliasField("MsgType", ReplyMusicMessage.class, "messageType");
	             xstream.aliasField("FuncFlag", ReplyMusicMessage.class, "funcFlag");
	             xstream.aliasField("Music", ReplyMusicMessage.class, "Music");
	             
	             xstream.aliasField("Title", Music.class, "title");
	             xstream.aliasField("Description", Music.class, "description");
	             xstream.aliasField("MusicUrl", Music.class, "musicUrl");
	             xstream.aliasField("HQMusicUrl", Music.class, "hqMusicUrl");
	            
	             String xml =xstream.toXML(we);
	             return xml;
	     }
		     
		 //    回复图文消息
	     private String getReplyTuwenMessage(String fromUserName,String toUserName){
	         
	         ReplyTuwenMessage we = new ReplyTuwenMessage();
	 
	         Articles articles = new Articles();
	         
	         ArticlesItem item = new ArticlesItem();
	         
	         we.setMessageType("news");
	         we.setCreateTime(new Long(new Date().getTime()).toString());
	         we.setToUserName(fromUserName);  
	         we.setFromUserName(toUserName);
	         we.setFuncFlag("0");
	         we.setArticleCount(1);
	          
	         item.setTitle("俊介");
	         item.setDescription("俊介（SHUNSUKE）是Twitter上现在最流行的偶像犬，是哈多利系博美犬（即俗称英系博美），因为在网上卖萌而走红网络。");
	         item.setPicUrl("https://mp.weixin.qq.com/s/kq8ZfwMXI2vxusI1diIB_w");
	         item.setUrl("https://mp.weixin.qq.com/s/kq8ZfwMXI2vxusI1diIB_w");        
	        
	         articles.setItem(item);
	         we.setArticles(articles);
	          
	         XStream xstream = new XStream(new DomDriver()); 
	         xstream.alias("xml", ReplyTuwenMessage.class);
	         xstream.aliasField("ToUserName", ReplyTuwenMessage.class, "toUserName");
	         xstream.aliasField("FromUserName", ReplyTuwenMessage.class, "fromUserName");
	         xstream.aliasField("CreateTime", ReplyTuwenMessage.class, "createTime");
	         xstream.aliasField("MsgType", ReplyTuwenMessage.class, "messageType");
	         xstream.aliasField("Articles", ReplyTuwenMessage.class, "Articles");
	         
	         xstream.aliasField("ArticleCount", ReplyTuwenMessage.class, "articleCount");
	         xstream.aliasField("FuncFlag", ReplyTuwenMessage.class, "funcFlag");
	         
	         xstream.aliasField("item", Articles.class, "item");
	         
	         xstream.aliasField("Title", ArticlesItem.class, "title");
	         xstream.aliasField("Description", ArticlesItem.class, "description");
	         xstream.aliasField("PicUrl", ArticlesItem.class, "picUrl");
	         xstream.aliasField("Url", ArticlesItem.class, "url");
	        
	         String xml =xstream.toXML(we);
	         return xml;
	     }

	     
	     /**
	 	 * 地址跳转
	 	 */
	 	@RequestMapping("/weChatUrlResponse")
	 	@ResponseBody
	 	public WeChatResponse weChatUrlResponse(String responseUrl,HttpServletRequest request,HttpServletResponse response){
	 		WeChatResponse userResponse=dmsWeChatService.weChatUrlResponse(responseUrl,request,response);
	 		return userResponse;
	 	}
	 	
	 	
	 	/**
	 	 * 推送记录地址跳转
	 	 */
	 	@RequestMapping("/pushWeChatUrlResponse")
	 	@ResponseBody
	 	public WeChatResponse pushWeChatUrlResponse(String taskNo,String typeUrl,HttpServletRequest request,HttpServletResponse response){
	 		WeChatResponse userResponse=dmsWeChatService.pushWeChatUrlResponse(taskNo,typeUrl,request,response);
	 		return userResponse;
	 	}
	 	
	 	
	 	/**
	 	 * 获取openId
	 	 */
	 	@RequestMapping("/weChatGetOpenId")
	 	@ResponseBody
	 	public WeChatResponse weChatGetOpenId(HttpServletRequest request,HttpServletResponse response){
	 		WeChatResponse userResponse=dmsWeChatService.weChatGetOpenId(request,response);
	 		return userResponse;
	 	}
	 	
	 	
	 	/**
	 	 * 获取token
	 	 */
	 	@RequestMapping("/weChatToken")
	 	@ResponseBody
	 	public WeChatResponse weChatToken(HttpServletRequest request,HttpServletResponse response){
	 		WeChatResponse userResponse=dmsWeChatService.weChatToken(request,response);
	 		return userResponse;
	 	}
}
