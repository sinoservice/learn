package com.easyhome.dao.mb;


import org.apache.ibatis.annotations.Param;

import com.easyhome.po.mb.BusSequenceStorageBean;

/**
 * 
* @ClassName: BusSequenceStorageDao 
* @Description: TODO  
* @date 2016年11月18日 下午2:35:53 
*
 */
public interface BusSequenceStorageDao {
	
	//保存序列信息
    int insertBusSequenceData(BusSequenceStorageBean sequenceBean);
    
    //查询序列号信息
    BusSequenceStorageBean selectSequenceData(@Param("busId")String busId,@Param("busType") int busType);
}
