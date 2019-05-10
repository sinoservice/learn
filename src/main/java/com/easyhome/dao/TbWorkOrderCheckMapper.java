package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbWorkOrderCheck;
import com.easyhome.po.TbWorkOrderCheckExample;

public interface TbWorkOrderCheckMapper {
    int countByExample(TbWorkOrderCheckExample example);

    int deleteByExample(TbWorkOrderCheckExample example);

    int insert(TbWorkOrderCheck record);

    int insertSelective(TbWorkOrderCheck record);

    List<TbWorkOrderCheck> selectByExample(TbWorkOrderCheckExample example);

    int updateByExampleSelective(@Param("record") TbWorkOrderCheck record, @Param("example") TbWorkOrderCheckExample example);

    int updateByExample(@Param("record") TbWorkOrderCheck record, @Param("example") TbWorkOrderCheckExample example);
}