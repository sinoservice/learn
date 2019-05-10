package com.easyhome.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.easyhome.vo.tm.TMActionParse;
import com.easyhome.vo.tm.TMOrderInfo;
import com.easyhome.vo.tm.TmOrderDetail;
import com.easyhome.vo.tm.TmOrderDetailResult;
import com.google.gson.Gson;

public class TmImageUtil {

	/**
	 * 天猫商品地址
	 */
	public static final String TM_IMG_URL = "https://detail.tmall.com/item.htm?id=ACTION_ID";
	
	/**
	 * 天猫聚石塔地址
	 */
	public static final String TM_JST_URL = "http://121.199.162.68/eaju_tm_service/order/allNormal";
	
	
	
	
	public static String getTmItemUrl(String parentBizOrderId) throws Exception{
		
		//获取天猫订单的actionId
		String auctionId = getTmItemAuctionId(parentBizOrderId);
		
		//获取特定天猫商品地址
		String url = TM_IMG_URL.replace("ACTION_ID", auctionId);
		
		//获取html文本
		String html = getTmItemHtml(url);
		
		//获取
		String imgUrl = parseHtmlFindImg(html);
		
		return imgUrl;
	}


	/**
	 * 解析文档获取图片
	 * @param html
	 * @return
	 */
	private static String parseHtmlFindImg(String html) throws Exception{
		
		if(html!=null){
			//获取图片所在位置字符串索引
			int index = html.indexOf("J_ImgBooth");
			
			int start = index - 12;
			
			int end = index + 260;
			
			String substring = html.substring(start, end);
			
			String img = "";  
	        Pattern p_image;  
	        Matcher m_image;  
	        List<String> pics = new ArrayList<String>();  
	        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";  
	        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);  
	        m_image = p_image.matcher(substring);  
	        while (m_image.find()) {  
	            img = img + "," + m_image.group();  
	            // Matcher m =  
	            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img); 
	            while (m.find()) {  
	                pics.add(m.group(1));  
	            }  
	        } 
	        
	        if(pics.size()>0){
	        	return pics.get(0);
	        }
		}
		
		return null;
	}


	private static String getTmItemHtml(String url) throws Exception{
		String html = HttpXmlClient.get(url, HttpXmlClient.TEXT_PLAIN);
		return html;
	}


	/**
	 * 获取天猫订单的actionId
	 * @param bizParentOrderId
	 * @return
	 */
	private static String getTmItemAuctionId(String parentBizOrderId) throws Exception{
		
		String auctionId = null;
		
		Gson gson = new Gson();

		//请求actionId
		Map<String, String> params = new HashMap<>();
		params.put("parentBizOrderId", parentBizOrderId);
		params.put("page", 1+"");
		params.put("pageSize", 10+"");
		String post = HttpXmlClient.post(TM_JST_URL, params);
		
		TMActionParse parse = gson.fromJson(post, TMActionParse.class);
		
		if(parse!=null && parse.getReturnCode() != 222){
			List<TmOrderDetail> data = parse.getData();
			if(data!=null && data.size()>0){
				TmOrderDetail tmOrderDetail = data.get(0);
				if(tmOrderDetail!=null){
					String orderDetail = tmOrderDetail.getOrderDetail();
					if(orderDetail!=null){
						TmOrderDetailResult result = gson.fromJson(orderDetail, TmOrderDetailResult.class);
						if(result!=null){
							TMOrderInfo orderInfo = result.getResult();
							if(orderInfo!=null){
								auctionId = orderInfo.getAuctionId();
							}
						}
					}
				}
			}
		}
		return auctionId;
	}
}
