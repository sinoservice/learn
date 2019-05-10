package com.easyhome.dao;

import java.util.List;
import java.util.Map;

import com.easyhome.po.OrderDateQueryBean;
/**
 * 
 * @date 2016骞�11鏈�4鏃� 涓婂崍11:07:34
 * @Discripition 
 * <p>Company: eaju</p>
 * @version 1.0
 */
public interface OrderDateQueryDao {
    List<OrderDateQueryBean> findWorkOrderListByMonth(Map<String,Object> params) throws Exception;
    
    int find();

}
