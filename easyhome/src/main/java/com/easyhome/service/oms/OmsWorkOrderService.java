package com.easyhome.service.oms;

import com.easyhome.po.oms.AppRankingListRequestEntity;
import com.easyhome.vo.BaseResponse;

/**
 * 
 * <p> Title: OmsWorkOrderService</p>
 * <p> Description: oms工单服务接口</p>
 * 
 * @date 2016年6月24日 下午2:05:31
 * @version 1.0
 *
 */
public interface OmsWorkOrderService {

	/**
	 * 排行榜
	 * @param request
	 * @return
	 */
	public String findOmsRankingList(AppRankingListRequestEntity request);

	/**
	 * 
	 * <p> Description: 记录地理信模拟</p>
	 * 
	 * @date 2016年6月24日 下午2:29:01
	 * @version 1.0
	 * @param workorderid
	 * @param address
	 * @return
	 */
	public BaseResponse addMessage(String workorderid, String address);

	/**
	 * 
	 * <p> Description: 保存回访信息</p>
	 * 
	 * @date 2016年7月5日 下午4:58:01
	 * @version 1.0
	 * @param workOrderId
	 * @param evalServiceComplete
	 * @param evalPhoneBack
	 * @param satisfaction1
	 * @param satisfaction2
	 * @param satisfaction3
	 * @param customerEval
	 * @return
	 */
	public String saveAppraise(
			String workOrderId, 
			int evalServiceComplete, 
			int evalPhoneBack, 
			int satisfaction1,
			int satisfaction2, 
			int satisfaction3, 
			String customerEval);

	/**
	 * 
	 * <p>description: 查询评价结果</p>
	 * @param workOrderId
	 * @return
	 * @date 2016年10月21日 下午2:24:07
	 */
	public String findAppraiseResult(String workOrderId);

}
