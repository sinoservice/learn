package com.easyhome.controller.oms;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * <p>title: AppTamllFeeAdjustController</p>
 * <p>description: APP天猫费用调整单操作控制器</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
* @Description: TODO 
* @date 2016年9月1日 下午1:54:43 
*
 */

import com.easyhome.po.oms.AdjustRequest;
import com.easyhome.service.oms.AppTamllFeeAdjustService;
import com.easyhome.vo.AdjustResult;

@RestController
@RequestMapping("/app/Tamll")
public class AppTamllFeeAdjustController {
	private static final Logger logger = Logger.getLogger(AppTamllFeeAdjustController.class);
    
	@Resource
	private AppTamllFeeAdjustService appTamllFeeAdjustService;

	/**
	 * 
	 * @Title: search
	 * @Description: TODO 查询调整费用单
	 * @param @param
	 *            masterId 技师编码
	 * @param @param
	 *            orderNo 派工单号
	 * @param @return
	 * @return String
	 * @date 2016年9月1日 下午3:23:39
	 */
	@RequestMapping("/search")
	@ResponseBody
	public String search(String masterId, String orderNo) {
		String data = appTamllFeeAdjustService.search(masterId, orderNo);
		return data;
	}

	/**
	 * 
	 * @Title: apply
	 * @Description: TODO 申请调整费用单
	 * @param @param
	 *            adjustRequest
	 * @param @return
	 * @return AdjustResult
	 * @date 2016年9月1日 下午4:28:05
	 */
	@RequestMapping("/apply")
	@ResponseBody
	public AdjustResult apply(AdjustRequest adjustRequest) {
		// Gson gson = new Gson()
		AdjustResult result = appTamllFeeAdjustService.apply(adjustRequest);
		return result;
	}

	/**
	 * 
	 * @Title: cancel
	 * @Description: TODO 取消调整费用单
	 * @param @param
	 *            masterId 技师编码
	 * @param @param
	 *            ethcId 调整単id
	 * @param @return
	 * @return AdjustResult
	 * @date 2016年9月1日 下午5:00:36
	 */
	@RequestMapping("/cancel")
	@ResponseBody
	public AdjustResult cancel(String masterId, String ethcId) {
		AdjustResult result = appTamllFeeAdjustService.cancel(masterId, ethcId);
		return result;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO 修改调整费用单
	 * @param @param
	 *            adjustRequest
	 * @param @return
	 * @return AdjustResult
	 * @date 2016年9月1日 下午5:19:11
	 */
	@RequestMapping("/update")
	@ResponseBody
	public AdjustResult update(AdjustRequest adjustRequest) {
		AdjustResult result = appTamllFeeAdjustService.update(adjustRequest);
		return result;
	}

	/**
	 * 
	 * @Title: noNeedInstall
	 * @Description: TODO 无需安装请求
	 * @param @param
	 *            orderNo 派工单号
	 * @param @param
	 *            ethcid 商品id
	 * @param @param
	 *            remark 无需安装的理由
	 * @param @return
	 * @return AdjustResult
	 * @date 2016年9月1日 下午5:30:39
	 */
	@RequestMapping("/noNeedInstall")
	@ResponseBody
	public AdjustResult noNeedInstall(String orderNo, String[] ethcId, String remark) {
		AdjustResult result = appTamllFeeAdjustService.noNeedInstall(orderNo, ethcId, remark);
		return result;
	}
	
	/**
	 * @Description: TODO 获取费用调整类型数据 
	 * @param orderNo
	 * @return
	 */
	@RequestMapping("/appGetAdjustTypeData")
	@ResponseBody
	public String appGetAdjustTypeData(String orderNo){
		return appTamllFeeAdjustService.appGetAdjustTypeData(orderNo);
	}
	
	/**
	 * @Description: TODO 申请费用调整单
	 * @param requestJson
	 * @return
	 */
	@RequestMapping("/appOutLineFeeAdjust")
	@ResponseBody
	public String appOutLineFeeAdjust(String requestJson){
		return appTamllFeeAdjustService.appOutLineFeeAdjust(requestJson);
	}
	
	/**
	 * @Description: TODO 费用调整单详情
	 * @param requestJson
	 * @return
	 */
	@RequestMapping("/appFeeApplyIterface")
	@ResponseBody
	public String appFeeApplyIterface(String workorderid, String masterid){
		return appTamllFeeAdjustService.appFeeApplyIterface(workorderid, masterid);
	}
	
	/**
	 * @Description: TODO 费用调整单查询
	 * @param requestJson
	 * @return
	 */
	@RequestMapping("/appFeeAdjustSearch")
	@ResponseBody
	public String appFeeAdjustSearch(String masterId, String orderNo, String itemId){
		return appTamllFeeAdjustService.appFeeAdjustSearch(masterId, orderNo, itemId);
	}
	
	/**
	 * @Description: TODO 按明细行签收确认接口(配送/安装)
	 * @param DeliveryFinishedBean bean
	 * @return
	 */
	@RequestMapping("/appDeliveryFinished")
	@ResponseBody
	public String appDeliveryFinished(String data){
		return appTamllFeeAdjustService.appDeliveryFinished(data);
	}
}
