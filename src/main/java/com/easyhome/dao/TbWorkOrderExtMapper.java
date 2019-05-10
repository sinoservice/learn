package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbWorkOrderExt;
import com.easyhome.po.TbWorkOrderExtExample;

public interface TbWorkOrderExtMapper {
    int countByExample(TbWorkOrderExtExample example);

    int deleteByExample(TbWorkOrderExtExample example);

    int insert(TbWorkOrderExt record);

    int insertSelective(TbWorkOrderExt record);

    List<TbWorkOrderExt> selectByExample(TbWorkOrderExtExample example);

    int updateByExampleSelective(@Param("record") TbWorkOrderExt record, @Param("example") TbWorkOrderExtExample example);

    int updateByExample(@Param("record") TbWorkOrderExt record, @Param("example") TbWorkOrderExtExample example);
}