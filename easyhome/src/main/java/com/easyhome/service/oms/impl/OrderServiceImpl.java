package com.easyhome.service.oms.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.po.oms.AppObtainDispatchOrderRequestEntity;
import com.easyhome.po.oms.FindWorkOrderRequest;
import com.easyhome.po.oms.GetPictureRequest;
import com.easyhome.po.oms.InstallNodeQueryRequest;
import com.easyhome.po.oms.InstallNodeSaveRequest;
import com.easyhome.po.oms.PrivacyNumberRequest;
import com.easyhome.po.oms.RevokeWorkOrderDetail;
import com.easyhome.po.oms.RevokeWorkOrderRequest;
import com.easyhome.po.oms.SearchWorkOrderRequest;
import com.easyhome.po.oms.WorkOrderResponse;
import com.easyhome.po.oms.WorkOrderRevoke;
import com.easyhome.service.oms.OrderService;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.TmImageUtil;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.MyResponse;
import com.easyhome.vo.OrderResult;
import com.google.gson.Gson;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);

	/**
	 * 查询工单
	 */
	@Override
	public String findWorkOrder(FindWorkOrderRequest request) {
		OrderResult result = new OrderResult();
		Gson gson = new Gson();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("masterid", request.getOmsMasterId());
			params.put("staus", request.getStatus());
			params.put("pageindex", request.getPageindex());
			params.put("pagesize", request.getPagesize());
			return OmsConnectUtil.getData("appQueryDispatchOrder", gson.toJson(params));
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常", e);
			return gson.toJson(result);
		}
	}
	
	/**
	 * 抢单、取消抢单
	 */
	@Override
	public String appObtainDispatchOrder(AppObtainDispatchOrderRequestEntity request) {
		OrderResult result = new OrderResult();
		Gson gson = new Gson();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("workNo", request.getWorkNo());
			params.put("masterId", request.getMasterId());
			params.put("type", request.getType());
			return OmsConnectUtil.getData("appObtainDispatchOrder", gson.toJson(params));
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("请求失败");
			return gson.toJson(result);
		}
	}

	/**
	 * 搜索工单
	 */
	@Override
	public String searchWorkOrder(SearchWorkOrderRequest request) {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		List<WorkOrderResponse> list = new ArrayList<>();
		WorkOrderResponse response = new WorkOrderResponse();
		try {
			if (!(request.getSearchWords() == null || "".equals(request.getSearchWords().trim()))) {

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("searchWords", request.getSearchWords());
				params.put("masterid", request.getOmsMasterId());
				params.put("pageindex", request.getPageIndex());
				params.put("pagesize", request.getPagesize());
				String resultJson = OmsConnectUtil.getData("appQueryDispatchOrderVague", params);
				String replace = resultJson.replace("errCode", "returnCode").replace("errMsg", "info");
				logger.info(replace);
				logger.info("查询成功");
				return replace;
			} else {
				br.setReturnCode(500);
				br.setInfo("请检查后重新输入");
				logger.info("请检查后重新输入");
			}
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("数据获取异常");
			logger.error("数据获取异常", e);
		}
		return gson.toJson(br);
	}

	/**
	 * 查询工单明细
	 */
	@Override
	public String findWorkOrderDetail(String workorderid, String omsMasterId) {
		OrderResult or = new OrderResult();
		Gson gson = new Gson();
		String result = "";
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("workorderid", workorderid);
			map.put("masterid",omsMasterId);
			result = OmsConnectUtil.getData("appQueryDispatchDetail", map);
			logger.info(result);
			return result;
		} catch (Exception e) {
			or.setErrCode(ReturnCode.STATUS_500);
			or.setErrMsg("数据获取异常");
			logger.error("数据获取异常",e);
			return gson.toJson(or);
		}
	}

	/**
	 * 查询撤单
	 */
	@Override
	public BaseResponse revokeWorkOrder(RevokeWorkOrderRequest request) {
		BaseResponse response = new BaseResponse();
		List<WorkOrderRevoke> list = new ArrayList<>();
		WorkOrderRevoke revoke = new WorkOrderRevoke();
		try {
			if (request.getOmsMasterId() != null || !("".equals(request.getOmsMasterId()))) {
				revoke.setAmount(100);
				revoke.setAuditStatus(2);
				revoke.setFid("12");
				revoke.setWorkNo("213213");
				revoke.setPlatFormName("北京");
				revoke.setCusName("貂蝉");
				revoke.setCusAddress("格式");
				revoke.setCusTel("111");
				revoke.setSendDate(new Date());
				revoke.setSender("吕布");
				revoke.setCompleteDate(new Date());
				revoke.setStatusDisplay("1");
				revoke.setViewTime(new Date());
				revoke.setMasterName("董卓");
				revoke.setMasterPhone("120");
				revoke.setStatus(1);
				revoke.setBillDate(new Date());
				revoke.setRemark("djfh");
				revoke.setRevokeTime(new Date());
				revoke.setRevokeName("袁绍");
				revoke.setRevokeCause("无");
				revoke.setWorkOrderSn("df");
				list.add(revoke);
				response.setData(list);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setInfo("查询成功");
				logger.info("查询成功");
			} else {
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setInfo("工单号不存在，请检查后重新输入");
				logger.info("工单号不存在，请检查后重新输入");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("数据获取异常", e);
		}
		return response;
	}

	/**
	 * 查询撤单详情
	 */
	@Override
	public MyResponse revokeWorkOrderDetial(String omsMasterId, String fid) {
		MyResponse response = new MyResponse();
		RevokeWorkOrderDetail orderDetail = new RevokeWorkOrderDetail();
		List<Object> detail = new ArrayList<>();
		try {
			orderDetail.setAddPrice(0);
			orderDetail.setAmount(200);
			orderDetail.setBrandName("北京");
			orderDetail.setFid("1234556");
			orderDetail.setGoodsImage(null);
			orderDetail.setGoodsName("浴缸");
			orderDetail.setGoodsNo("2201");
			orderDetail.setGoodsSize("20");
			orderDetail.setHandleFreight(0);
			orderDetail.setHandleInstallFee(0);
			orderDetail.setHandleOldFee(0);
			orderDetail.setHandleRemoteFee(0);
			orderDetail.setHandleSecondFee(0);
			orderDetail.setHandleSmallFee(0);
			orderDetail.setHandleTotal(0);
			orderDetail.setInstallPrice(250.0);
			orderDetail.setItemAmount(200);
			orderDetail.setItemName("衣架");
			orderDetail.setOmsId("212313");
			orderDetail.setPrice(500);
			orderDetail.setQuantity(320.0);
			orderDetail.setReceivablesFreight(0);
			orderDetail.setReceivablesInstallFee(0);
			orderDetail.setReceivablesOldFee(0);
			orderDetail.setReceivablesRemoteFee(0);
			orderDetail.setReceivablesSecondFee(0);
			orderDetail.setReceivablesSmallFee(0);
			orderDetail.setReceivablesTotal(0);
			orderDetail.setRemark("无");
			orderDetail.setRequirement("1222");
			orderDetail.setTimes("2016-02-13 12:22:22");
			orderDetail.setUnit("1212");
			orderDetail.setWorkOrderId("121212");
			detail.add(orderDetail);
			response.setDetail(detail);
			List<WorkOrderRevoke> list = new ArrayList<>();
			WorkOrderRevoke revoke = new WorkOrderRevoke();
			revoke.setAmount(100);
			revoke.setAuditStatus(2);
			revoke.setFid("12");
			revoke.setWorkNo("213213");
			revoke.setPlatFormName("北京");
			revoke.setCusName("貂蝉");
			revoke.setCusAddress("格式");
			revoke.setCusTel("111");
			revoke.setSendDate(new Date());
			revoke.setSender("吕布");
			revoke.setCompleteDate(new Date());
			revoke.setStatusDisplay("1");
			revoke.setViewTime(new Date());
			revoke.setMasterName("董卓");
			revoke.setMasterPhone("120");
			revoke.setStatus(1);
			revoke.setBillDate(new Date());
			revoke.setRemark("djfh");
			revoke.setRevokeTime(new Date());
			revoke.setRevokeName("袁绍");
			revoke.setRevokeCause("无");
			revoke.setWorkOrderSn("df");
			list.add(revoke);
			response.setData(list);
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo("查询成功");
			logger.info("查询成功");
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("数据获取异常", e);
		}
		return response;
	}

	@Override
	public BaseResponse findTmOrderImage(String parentBizOrderId) throws Exception {
		BaseResponse br = new BaseResponse();

		try {
			String tmItemUrl = TmImageUtil.getTmItemUrl(parentBizOrderId);
			if (tmItemUrl != null && !"".equals(tmItemUrl)) {
				br.setData(tmItemUrl);
				br.setInfo("获取天猫图片路径成功");
				br.setReturnCode(200);
			} else {
				br.setInfo("图片路径不存在");
				br.setReturnCode(404);
			}
		} catch (Exception e) {
			br.setInfo("位置错误异常");
			br.setReturnCode(404);
		}
		return br;
	}
	
	@Override
	public String appQueryMaterialGroup(InstallNodeQueryRequest request) throws Exception {
		Gson gson = new Gson();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("etdlno", request.getEtdlno());
			params.put("skuid", request.getSkuid());
			params.put("groupcode", request.getGroupcode());
			params.put("currentindex", request.getCurrentindex());
			String result = OmsConnectUtil.getData("appQueryMaterialGroup", gson.toJson(params));
			String replace = result.replace("errCode", "returnCode").replace("errMsg", "info");
			return replace;
		} catch (Exception e) {
			OrderResult result = new OrderResult();
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常", e);
			return gson.toJson(result).replace("errCode", "returnCode").replace("errMsg", "info");
		}
	}
	
	@Override
	public String appSaveInstallNode(InstallNodeSaveRequest request) throws Exception {
		Gson gson = new Gson();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("etdlno", request.getEtdlno());
			params.put("skuid", request.getSkuid());
			params.put("emincode", request.getEmincode());
			params.put("groupcode", request.getGroupcode());
			params.put("installindex", request.getInstallindex());
			params.put("picturecontent", request.getPicturecontent());
			String result = OmsConnectUtil.getData("appSaveInstallNode", gson.toJson(params));
			String replace = result.replace("errCode", "returnCode").replace("errMsg", "info");
			return replace;
		} catch (Exception e) {
			OrderResult result = new OrderResult();
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常", e);
			return gson.toJson(result).replace("errCode", "returnCode").replace("errMsg", "info");
		}
	}
	
	
	@Override
	public void appGetPicture(GetPictureRequest request,HttpServletResponse response){
		Gson gson = new Gson();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("masterId", request.getMasterId());
			params.put("type", request.getType());	
			OmsConnectUtil.getResponseData("appGetPicture", gson.toJson(params),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询工单
	 */
	@Override
	public String getPrivacyNumber(PrivacyNumberRequest request) {
		OrderResult result = new OrderResult();
		Gson gson = new Gson();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("masterid", request.getWorkorderid());
			params.put("phoneno", request.getPhoneno());			
			return OmsConnectUtil.getData("getPrivacyNumber", gson.toJson(params));
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常", e);
			return gson.toJson(result);
		}
	}
}