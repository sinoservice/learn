package com.easyhome.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.WorkOrderService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BadgeRanking;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.MasterBadge;

/**
 * 
 * <p> Title: MasterController</p>
 * <p> Description: 技师视图控制器</p>
 * 
 * @date 2016年5月23日 下午3:38:01
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/master")
public class MasterController implements Serializable{
	
	@Autowired
	private WorkOrderService workOrderService;

	private static final long serialVersionUID = -2652654613952565927L;
	
	/**
	 * 
	 * <p> Description: 通过技师获得技师的徽章详情</p>
	 * 
	 * @date 2016年5月23日 下午3:43:23
	 * @version 1.0
	 * @param masterId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/myBadge")
	@ResponseBody
	public BaseResponse getBadge(String masterId) throws Exception{
		BaseResponse br = new BaseResponse();
		try {
			MasterBadge badge = workOrderService.getBadgeByMasterId(masterId);
			br.setReturnCode(ReturnCode.STATUS_200);
			br.setInfo("请求成功");
			br.setData(badge);
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
		}
		return br;
	}
	
	
	/**
	 * 
	 * <p> Description: 获取徽章排名</p>
	 * 
	 * @date 2016年5月23日 下午5:28:06
	 * @version 1.0
	 * @param masterId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/myRanking")
	@ResponseBody
	public BaseResponse findRanking(String masterId) throws Exception{
		BaseResponse br = new BaseResponse();
		try {
			List<BadgeRanking> rankingList = workOrderService.findRankingList(masterId);
			br.setReturnCode(ReturnCode.STATUS_200);
			br.setInfo("请求成功");
			br.setData(rankingList);
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
		}
		return br;
	}

}
