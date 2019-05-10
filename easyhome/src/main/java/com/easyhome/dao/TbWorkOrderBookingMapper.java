package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbWorkOrderBooking;
import com.easyhome.po.TbWorkOrderBookingExample;

public interface TbWorkOrderBookingMapper {
    int countByExample(TbWorkOrderBookingExample example);

    int deleteByExample(TbWorkOrderBookingExample example);

    int insert(TbWorkOrderBooking record);

    int insertSelective(TbWorkOrderBooking record);

    List<TbWorkOrderBooking> selectByExample(TbWorkOrderBookingExample example);

    int updateByExampleSelective(@Param("record") TbWorkOrderBooking record, @Param("example") TbWorkOrderBookingExample example);

    int updateByExample(@Param("record") TbWorkOrderBooking record, @Param("example") TbWorkOrderBookingExample example);
}