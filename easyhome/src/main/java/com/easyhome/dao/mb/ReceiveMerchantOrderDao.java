package com.easyhome.dao.mb;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.mb.ReceiveMerchantOrderBean;
/**
 * 
 * @date 2016年11月17日 下午5:29:31
 * @Discripition 接收三方商家报文的Dao接口
 * <p>Company: eaju</p>
 * @version 1.0
 */
public interface ReceiveMerchantOrderDao {
    
    /**
     * @return 
     * 
    * @Title: receiveMeiBiaoOrderDao 
    * @Description: 接收美标报文的Dao接口
    * @param @param receiveMeiBiaoOrderBean    设定文件 
    * @return void    
    * @throws receiveMeiBiaoOrderDao
     */
    int insertMerchantOrderDao(ReceiveMerchantOrderBean receiveMeiBiaoOrderBean);
   
    /**
     * 
    * @Title: updateMerchantOrderDao 
    * @Description: TODO 
    * @param @param receiveMeiBiaoOrderBean
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    int updateMerchantOrderDao(ReceiveMerchantOrderBean receiveMeiBiaoOrderBean);
    
    List<ReceiveMerchantOrderBean> selectMerchantOrder(@Param("businessKey")String businessKey);    
}
