package com.easyhome.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbWorkOrder;
import com.easyhome.po.TbWorkOrderExample;
import com.easyhome.vo.BadgeRanking;
import com.easyhome.vo.MasterBadge;
import com.easyhome.vo.ReminderWorkOrder;
import com.easyhome.vo.ReminderWorkOrderQuery;
import com.easyhome.vo.SatisfiedByMasterCustom;
import com.easyhome.vo.SatisfiedByMasterQuery;
import com.easyhome.vo.SatisfiedByWokeOrderCustom;
import com.easyhome.vo.SatisfiedByWokeOrderQuery;
import com.easyhome.vo.bos.OrderStatusBean;

public interface TbWorkOrderMapperCustom {
	/**
	 * 
	 * <p> Description: 通过技师的id查询技师的徽章</p>
	 * 
	 * @date 2016年5月23日 下午3:18:06
	 * @version 1.0
	 * @param masterId
	 * @return
	 */
	public MasterBadge getBadgeByMasterId(String masterId);
	
	/**
	 * 
	 * <p> Description: 获取徽章排行榜</p>
	 * 
	 * @date 2016年5月23日 下午5:19:30
	 * @version 1.0
	 * @param masterId
	 * @return
	 */
	public List<BadgeRanking> findRankingList(String masterId);
	
	/**
	 * 
	 * <p> Description: 以工单为维度获得工单满意度报表</p>
	 * 
	 * @date 2016年5月25日 下午5:13:59
	 * @version 1.0
	 * @param satisfiedByWokeOrderQuery
	 * @return
	 */
	public List<SatisfiedByWokeOrderCustom> calculateSatisfiedReportByOrderList(SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery);
	
	/**
	 * 
	 * <p> Description: 以工单为维度获得工单满意度报表记录数</p>
	 * 
	 * @date 2016年5月26日 上午11:31:44
	 * @version 1.0
	 * @param satisfiedByWokeOrderQuery
	 * @return
	 */
	public int calculateSatisfiedReportByOrderCount(SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery);
	
	/**
	 * 
	 * <p> Description: 获取省份下拉列表</p>
	 * 
	 * @date 2016年5月27日 下午1:26:38
	 * @version 1.0
	 * @return
	 */
	public List<String> getProvince();
	
	/**
	 * 
	 * <p> Description: 获取调度平台列表</p>
	 * 
	 * @date 2016年5月27日 下午1:34:02
	 * @version 1.0
	 * @return
	 */
	public List<String> getOrganize();
	
	/**
	 * 
	 * <p> Description: 技师满意度列表</p>
	 * 
	 * @date 2016年5月27日 下午3:54:31
	 * @version 1.0
	 * @param satisfiedByMasterQuery
	 * @return
	 */
	public List<SatisfiedByMasterCustom> calculateSatisfiedByMasterList(SatisfiedByMasterQuery satisfiedByMasterQuery);
	
	/**
	 * 
	 * <p> Description: 查询总记录数</p>
	 * 
	 * @date 2016年5月27日 下午4:39:55
	 * @version 1.0
	 * @param satisfiedByMasterQuery
	 * @return
	 */
	public int calculateSatisfiedByMasterCount(SatisfiedByMasterQuery satisfiedByMasterQuery);
	
	/**
	 * 
	 * <p> Description: 催单列表</p>
	 * 
	 * @date 2016年6月3日 下午4:28:53
	 * @version 1.0
	 * @param query
	 * @return
	 */
	public List<ReminderWorkOrder> findReminderWorkOrderList(ReminderWorkOrderQuery query);
	
	/**
	 * 
	 * <p> Description: 催单总记录数</p>
	 * 
	 * @date 2016年6月3日 下午4:30:03
	 * @version 1.0
	 * @param query
	 * @return
	 */
	public int findReminderWorkOrderCount(ReminderWorkOrderQuery query);
	
	/**
	 * 
	 * <p> Description: 写入预约时间</p>
	 * 
	 * @date 2016年6月28日 下午9:33:46
	 * @version 1.0
	 * @param tbWorkOrder
	 */
	int updateByExampleSelective(@Param("record") TbWorkOrder record, @Param("example") TbWorkOrderExample example);

	/**
	 * 
	 * <p>description: 查找验证码</p>
	 * @param workNo
	 * @return
	 * @date 2016年7月27日 下午8:48:32
	 */
	List<String> findCheckCodeByWorkNo(@Param("workNo") String workNo);
	
	/**
	 * 
	 * <p>description: 获取状态信息用于状态的回传</p>
	 * @param status
	 * @return
	 * @date 2016年8月8日 上午8:46:27
	 */
	List<OrderStatusBean> getWorkOrderStatus(int status);
}
