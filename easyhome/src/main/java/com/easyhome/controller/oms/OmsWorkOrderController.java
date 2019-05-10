package com.easyhome.controller.oms;

import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.oms.AppRankingListRequestEntity;
import com.easyhome.service.AppraiseService;
import com.easyhome.service.WorkOrderService;
import com.easyhome.service.oms.OmsWorkOrderService;
import com.easyhome.vo.BaseResponse;

/**
 * 
 * <p> Title: OmsWorkOrderController</p>
 * <p> Description: 与锐特对接部分工单服务接口</p>
 * 
 * @date 2016年6月23日 下午1:41:44
 * @version 1.0
 *
 */
@Controller
public class OmsWorkOrderController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OmsWorkOrderController.class);
	
	Log log = LogFactory.getLog(OmsWorkOrderController.class);
	
	@Resource
	private AppraiseService service;
	
	@Autowired
	private WorkOrderService workOrderService;
	
	@Autowired
	private OmsWorkOrderService omsWorkOrderService;

	/**
	 * 排行榜
	 * @param request
	 * @return
	 */
	@RequestMapping("/oms/master/myRanking")
	@ResponseBody
	public String findRanking(AppRankingListRequestEntity request) {
		return omsWorkOrderService.findOmsRankingList(request);
	}
	
	
	@RequestMapping(value="/oms/appraise/saveAppraise/{workOrderId}",method=RequestMethod.GET)
	public String save(@PathVariable String workOrderId) throws Exception{
		
		String result = this.omsWorkOrderService.findAppraiseResult(workOrderId);
		
		return result;
	}

	/**
	 * 
	 * <p> Description: 保存评价信息</p>
	 * 
	 * @date 2016年6月23日 下午1:46:29
	 * @version 1.0
	 * @param workOrderId
	 * @param evalServiceComplete
	 * @param evalPhoneBack
	 * @param satisfaction1
	 * @param satisfaction2
	 * @param satisfaction3
	 * @param customerEval
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/oms/appraise/saveAppraise/{workOrderId}",method=RequestMethod.POST)
	public String saveAppraise(
			@PathVariable(value="workOrderId") String workOrderId,
			@RequestParam(defaultValue="0") int evalServiceComplete,
			@RequestParam(defaultValue="0") int evalPhoneBack,
			@RequestParam(defaultValue="0") int satisfaction1,
			@RequestParam(defaultValue="0") int satisfaction2,
			@RequestParam(defaultValue="0") int satisfaction3,
			@RequestParam(defaultValue="") String customerEval) throws Exception{
		
		BaseResponse br = new BaseResponse();
		
		log.info("evalServiceComplete:"+evalServiceComplete);
		log.info("evalPhoneBack:"+evalPhoneBack);
		log.info("satisfaction1:"+satisfaction1);
		log.info("satisfaction2:"+satisfaction2);
		log.info("satisfaction3:"+satisfaction3);
		log.info("workOrderId:"+workOrderId);
		log.info("customerEval:"+customerEval);
		try {
			String saveAppraiseResult = omsWorkOrderService.saveAppraise(
					workOrderId,
					evalServiceComplete,
					evalPhoneBack,
					satisfaction1,
					satisfaction2,
					satisfaction3,
					customerEval);
			return saveAppraiseResult;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			log.info("短信发送失败：",e);
		}
					
		return "appraise/fail";
	}
	
	/**
	 * 
	 * <p> Description: 完工汇报保存二维码生成地址</p>
	 * 
	 * @date 2016年6月23日 下午1:58:27
	 * @version 1.0
	 * @param workorderid
	 * @param address
	 * @return
	 */
	@RequestMapping(value="/oms/appraise/addAddress",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse execute(String workorderid,String address){
		BaseResponse response = omsWorkOrderService.addMessage(workorderid, address);
		return response;
	}
	
	
	/**
	 * 
	 * <p> Description: 完工汇报，上传图片</p>
	 * 
	 * @date 2016年6月23日 下午1:59:59
	 * @version 1.0
	 * @param workorderid
	 * @param masterid
	 * @param mastername
	 * @param remark
	 * @param workorderitemid
	 * @param phone
	 * @param name
	 * @param address
	 * @param image
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/oms/workOrder/addCompleteInfo"},method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse addCompleteInfo(
			@RequestParam(defaultValue="") String workorderid,
			@RequestParam(defaultValue="") String omsMasterId,
			@RequestParam(defaultValue="") String mastername,
			@RequestParam(defaultValue="") String remark,
			@RequestParam(defaultValue="") String workorderitemid,
			@RequestParam(defaultValue="") String phone,
			@RequestParam(defaultValue="") String name,
			@RequestParam(defaultValue="") String address,
			@RequestParam(defaultValue="") String image,
			HttpServletRequest request
			){
		
		log.info("workorderid:"+workorderid);
		log.info("masterid:"+omsMasterId);
		log.info("mastername:"+mastername);
		log.info("remark:"+remark);
		log.info("workorderitemid:"+workorderitemid);
		log.info("phone:"+phone);
		log.info("name:"+name);
		log.info("address:"+address);
		log.info("image:"+image);
		
		
		BaseResponse br = new BaseResponse();
		String[] split = image.split("|");
		for (int i =0;i<split.length;i++) {
			request.getSession().getServletContext().getRealPath("/view/upload/"+i);
		}
		try {
			br.setReturnCode(200);
			br.setInfo("工单状态变更完毕");
			br.setData("SUCCESS");
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
		}
		return br;
	}
	
	
	/**
	 * 
	 * <p> Description: 部分完工汇报</p>
	 * 
	 * @date 2016年6月23日 下午5:05:05
	 * @version 1.0
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/oms/workOrder/partlyCompleted")
	@ResponseBody
	public String partlyCompleted(@RequestParam(defaultValue="") String data) throws Exception{
		log.info("=================== 完工参数 ===================");
		long start = System.currentTimeMillis();
		log.info(data);
		log.info("开始执行完工操作");
		String partlyCompleted = workOrderService.partlyCompleted(data);
		long end = System.currentTimeMillis();
		OmsConstant.COMPELET_COUNT ++;
		log.info("第" + OmsConstant.COMPELET_COUNT +" 次执行完工操作...");
		log.info("执行完工操作结束： 耗时" + (end - start) + "毫秒");
		return partlyCompleted;
	}
	
	
	@RequestMapping(value="/oms/workOrder/getPrivacyNumber")
	@ResponseBody
	public String getPrivacyNumber(@RequestParam(defaultValue="") String workorderid) throws Exception{
		log.info("=================== 取隐私号码 ===================");
		long start = System.currentTimeMillis();
		log.info(workorderid);
		log.info("开始执行获取隐私号码");
		String result = workOrderService.getPrivacyNumber(workorderid);
		long end = System.currentTimeMillis();
		log.info("执行获取隐私号码结束： 耗时" + (end - start) + "毫秒");
		return result;
	}
}
