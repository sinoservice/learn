package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbWorkOrder;
import com.easyhome.po.TbWorkOrderExample;

public interface TbWorkOrderMapper {
    int countByExample(TbWorkOrderExample example);

    int deleteByExample(TbWorkOrderExample example);

    int insert(TbWorkOrder record);

    int insertSelective(TbWorkOrder record);

    List<TbWorkOrder> selectByExample(TbWorkOrderExample example);

    int updateByExampleSelective(@Param("record") TbWorkOrder record, @Param("example") TbWorkOrderExample example);

    int updateByExample(@Param("record") TbWorkOrder record, @Param("example") TbWorkOrderExample example);
    
    TbWorkOrder selectWorkOrderById(@Param("workorderid") String workorderid);
    int batchUpdateWorkOrder(@Param("workOrderNos")List<String> workOrderNos,@Param("status") int status,@Param("statusDisplay") String statusDisplay);
}