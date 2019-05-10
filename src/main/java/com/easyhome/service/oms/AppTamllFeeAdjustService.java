package com.easyhome.service.oms;

import com.easyhome.po.oms.AdjustRequest;
import com.easyhome.vo.AdjustResult;

/**
 * 
* @ClassName: AppTamllFeeAdjustServiceI 
* @Description: TODO app天猫费用调整单操作
* @date 2016年9月1日 下午2:07:01 
*
 */
public interface AppTamllFeeAdjustService {
	/**
	 * 
	* @Title: search 
	* @Description: TODO 查询费用调整单
	* @param  @param masterId 技师编码
	* @param  @param orderNo 派工单号
	* @param  @return 
	* @return String    
	* @throws 
	* @date 2016年9月1日 下午2:09:53
	 */
    String search(String masterId,String orderNo);
    
    /**
     * 
    * @Title: apply 
    * @Description: TODO 申请费用调整单
    * @param  @param adjustRequest
    * @param  @return 
    * @return String   
    * @throws 
    * @date 2016年9月1日 下午3:53:35
     */
    AdjustResult apply(AdjustRequest adjustRequest);
    
    /**
     * 
    * @Title: cancel 
    * @Description: TODO 
    * @param  @param masterId 技师编码
    * @param  @param ethcId 调整単id
    * @param  @return 
    * @return AdjustResult    
    * @throws 
    * @date 2016年9月1日 下午4:51:03
     */
    AdjustResult  cancel(String masterId,String ethcId);
    
    /**
     * 
    * @Title: update 
    * @Description: TODO 修改调整费用单
    * @param  @param adjustRequest
    * @param  @return 
    * @return AdjustResult    
    * @throws 
    * @date 2016年9月1日 下午5:14:07I
     */
    AdjustResult  update(AdjustRequest adjustRequest);
    
    /**
     * 
    * @Title: noNeedInstall 
    * @Description: TODO 无需安装
    * @param  @param orderNo 派工单号
    * @param  @param ethcid  商品id
    * @param  @param remark  无需安装的理由
    * @param  @return 
    * @return AdjustResult    
    * @throws 
    * @date 2016年9月1日 下午5:21:44
     */
    AdjustResult noNeedInstall(String orderNo,String[] ethcId,String remark);
    
    /**
     * @Title: appGetAdjustTypeData
     * @Description: TODO 获取费用调整类型数据
     * @param orderNo
     * @return
     * @date 2017年1月6日 
     */
    String appGetAdjustTypeData(String orderNo);
    
    /**
     * @Title: appGetAdjustTypeData
     * @Description: TODO 申请费用调整单
     * @param requstJson
     * @return
     * @date 2017年1月6日 
     */
    String appOutLineFeeAdjust(String requestJson);
    
    /**
     * @Title: appQueryFeeDetail
     * @Description: TODO 费用调整单详情
     * @param workorderid,masterid
     * @return
     * @date 2017年1月9日 
     */
    String appFeeApplyIterface(String workorderid,String masterid);
    
    /**
     * @Title: appFeeAdjustSearch
     * @Description: TODO 费用调整单查询
     * @param masterId,orderNo,itemId
     * @return
     * @date 2017年1月9日 
     */
    String appFeeAdjustSearch(String masterId,String orderNo,String itemId);
    
    /**
     * @Title: appFeeAdjustSearch
     * @Description: TODO 按明细行签收确认接口(配送/安装)
     * @param masterId,orderNo,itemId
     * @return
     * @date 2017年1月9日 
     */
    String appDeliveryFinished(String data);
}
