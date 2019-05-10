package com.easyhome.dao;

import org.apache.ibatis.annotations.Param;

public interface AATestMapper {
    void addOrderFromFBS(@Param("OUT_ORDER_SN")String OUT_ORDER_SN);
}