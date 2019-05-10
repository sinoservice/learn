package com.easyhome.service.oms;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;

import com.easyhome.po.oms.AppObtainDispatchOrderRequestEntity;
import com.easyhome.po.oms.FindWorkOrderRequest;
import com.easyhome.po.oms.GetPictureRequest;
import com.easyhome.po.oms.InstallNodeQueryRequest;
import com.easyhome.po.oms.InstallNodeSaveRequest;
import com.easyhome.po.oms.PrivacyNumberRequest;
import com.easyhome.po.oms.RevokeWorkOrderRequest;
import com.easyhome.po.oms.SearchWorkOrderRequest;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.MyResponse;

public interface OrderService {
//	OrderResult findWorkOrder(String masterid,Integer pageIndex,Integer pagesize);
	/**
	 * 
	 * <p> Description: 工单列表</p>
	 * 
	 * @date 2016年7月5日 上午11:43:06
	 * @version 1.0
	 * @param request
	 * @return
	 */
	String findWorkOrder(FindWorkOrderRequest request);
	
	String appObtainDispatchOrder(AppObtainDispatchOrderRequestEntity request);
	
	/**
	 * 
	 * <p> Description: 工单查询</p>
	 * 
	 * @date 2016年7月5日 上午11:43:21
	 * @version 1.0
	 * @param request
	 * @return
	 */
	String searchWorkOrder(SearchWorkOrderRequest request);
	String findWorkOrderDetail(String workorderid,String omsMasterId);
	BaseResponse  revokeWorkOrder(RevokeWorkOrderRequest request);
	MyResponse revokeWorkOrderDetial(String omsMasterId,String fid);
	
	/**
	 * 获取天猫图片路径
	 * @param parentBizOrderId
	 * @return
	 */
	BaseResponse findTmOrderImage(String parentBizOrderId) throws Exception;
	
	
	public String appQueryMaterialGroup(InstallNodeQueryRequest request) throws Exception;
	
	public String appSaveInstallNode(InstallNodeSaveRequest request) throws Exception;
	
	public void appGetPicture(GetPictureRequest request,HttpServletResponse response);
	
	public String getPrivacyNumber(PrivacyNumberRequest request);
}
