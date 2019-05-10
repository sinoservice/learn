package com.easyhome.controller.oms;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.oms.AppObtainDispatchOrderRequestEntity;
import com.easyhome.po.oms.FindWorkOrderRequest;
import com.easyhome.po.oms.GetPictureRequest;
import com.easyhome.po.oms.InstallNodeQueryRequest;
import com.easyhome.po.oms.InstallNodeSaveRequest;
import com.easyhome.po.oms.PrivacyNumberRequest;
import com.easyhome.po.oms.RevokeWorkOrderRequest;
import com.easyhome.po.oms.SearchWorkOrderRequest;
import com.easyhome.service.oms.OrderService;
import com.easyhome.utils.EmptyUtils;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.MyResponse;
import com.google.gson.Gson;

@Controller
@RequestMapping("/oms/order")
public class OrderController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderController.class);

	/**
	 * 查询工单
	 * @param masterId
	 * @return
	 */
	@Resource
	private OrderService orderService;
	
	
	@RequestMapping("/findWorkOrder")
	@ResponseBody
	public String findWorkOrder(FindWorkOrderRequest request) {
//	public OrderResult findWorkOrder(String masterid,Integer pageIndex,Integer pagesize ) {
//		OrderResult OrderResult=orderService.findWorkOrder(masterid,pageIndex,pagesize);
		String OrderResult=orderService.findWorkOrder(request);
		return OrderResult;
	}
	
	/**
	 * 抢单、取消抢单
	 * @param request
	 * @return
	 */
	@RequestMapping("/appObtainDispatchOrder")
	@ResponseBody
	public String appObtainDispatchOrder(AppObtainDispatchOrderRequestEntity request) {
		String response = orderService.appObtainDispatchOrder(request);
		return response;
	}
	
	/**
	 * 搜索工单
	 */
	@RequestMapping("/searchWorkOrder")
	@ResponseBody
	public String searchWorkOrder(SearchWorkOrderRequest request) {
		logger.info(request);
		String OrderResult=orderService.searchWorkOrder(request);
		return OrderResult;
	}
	/**
	 * 查询工单明细
	 */
	@RequestMapping("/findWorkOrderDetail")
	@ResponseBody
	public String findWorkOrderDetail(String workorderid,String omsMasterId) {
		String OrderResult=orderService.findWorkOrderDetail(workorderid,omsMasterId);
		return OrderResult;
	}
	/**
	 * 查询撤单列表
	 */
//	@RequestMapping("/revokeWorkOrder")
//	public OrderResult revokeWorkOrder(String masterid,Integer pageIndex,Integer pagesize) {
//		OrderResult OrderResult=orderService.revokeWorkOrder(masterid,pageIndex,pagesize);
//		return OrderResult;
//	}
	@RequestMapping("/revokeWorkOrder")
	@ResponseBody
	public BaseResponse revokeWorkOrder(RevokeWorkOrderRequest request) {
		BaseResponse response=orderService.revokeWorkOrder(request);
		return response;
	}
	/**
	 * 查询撤单详情
	 * @param fid
	 * @return
	 */
	@RequestMapping("/revokeWorkOrderDetial")
	@ResponseBody
	public MyResponse revokeWorkOrderDetial(String omsMasterId,String fid) {
		MyResponse response=orderService.revokeWorkOrderDetial(omsMasterId,fid);
		return response;
	}
	
	/**
	 * 获取天猫图片
	 * @param parentBizOrderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findTmOrderImage")
	@ResponseBody
	public BaseResponse findTmOrderImage(String parentBizOrderId) throws Exception{
		return this.orderService.findTmOrderImage(parentBizOrderId);
	}
	
	
	/**
	 * 查询安装节点 (删除)
	 * @param parentBizOrderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/appQueryMaterialGroup")
	@ResponseBody
	public String appQueryMaterialGroup(InstallNodeQueryRequest request) throws Exception{
		return this.orderService.appQueryMaterialGroup(request);
	}
	
	/**
	 * 保存安装节点记录
	 * @param parentBizOrderId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/appSaveInstallNode")
	@ResponseBody
	public String appSaveInstallNode(InstallNodeSaveRequest request) throws Exception{
		return this.orderService.appSaveInstallNode(request);
	}
	
	
	/**
	 * 获取图片
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/appGetPicture")
	@ResponseBody
	public String appGetPicture(GetPictureRequest request,HttpServletResponse response) throws Exception{
		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		if(EmptyUtils.isEmpty(request.getMasterId())) {
			br.setReturnCode(404);
			br.setInfo("技师id不能为空");
			return gson.toJson(br);
		}
		if(EmptyUtils.isEmpty(request.getType())) {
			br.setReturnCode(404);
			br.setInfo("类型不能为空");
			return gson.toJson(br);
		}else {
			if(request.getType().equals("1") || request.getType().equals("2") || request.getType().equals("3")) {
				
			}else {
				br.setReturnCode(404);
				br.setInfo("类型值错误");
				return gson.toJson(br);
			}
		}
		this.orderService.appGetPicture(request,response);
		return null;
	}
	
	
	/**
	 * 获取图片
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/appGetPictureTest")
	@ResponseBody
	public void appGetPictureTest(GetPictureRequest request,HttpServletResponse response) throws Exception{
		CloseableHttpClient closeableHttpClient=HttpClients.createDefault(); //1、创建实例
        HttpGet httpGet=new HttpGet("http://static.bootcss.com/www/assets/img/codeguide.png?1505127079951"); //2、创建请求
         
        CloseableHttpResponse closeableHttpResponse=closeableHttpClient.execute(httpGet); //3、执行
        HttpEntity httpEntity=closeableHttpResponse.getEntity(); //4、获取实体
         
        if(httpEntity!=null){
            InputStream inputStream=httpEntity.getContent();
            OutputStream os = response.getOutputStream();
            int ch;
            while ((ch = inputStream.read()) != -1) {   
            	os.write(ch);   
            }
            response.flushBuffer();
        }
        closeableHttpResponse.close();
        closeableHttpClient.close();
	}
	
	
	/**
	 * 获取隐私号
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPrivacyNumber")
	@ResponseBody
	public String getPrivacyNumber(PrivacyNumberRequest request) throws Exception{
		return this.orderService.getPrivacyNumber(request);
	}
}
