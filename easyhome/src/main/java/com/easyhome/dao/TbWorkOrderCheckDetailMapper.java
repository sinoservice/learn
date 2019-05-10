package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbWorkOrderCheckDetail;
import com.easyhome.po.TbWorkOrderCheckDetailExample;

public interface TbWorkOrderCheckDetailMapper {
    int countByExample(TbWorkOrderCheckDetailExample example);

    int deleteByExample(TbWorkOrderCheckDetailExample example);

    int insert(TbWorkOrderCheckDetail record);

    int insertSelective(TbWorkOrderCheckDetail record);

    List<TbWorkOrderCheckDetail> selectByExample(TbWorkOrderCheckDetailExample example);

    int updateByExampleSelective(@Param("record") TbWorkOrderCheckDetail record, @Param("example") TbWorkOrderCheckDetailExample example);

    int updateByExample(@Param("record") TbWorkOrderCheckDetail record, @Param("example") TbWorkOrderCheckDetailExample example);
}