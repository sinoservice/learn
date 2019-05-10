package com.easyhome.dao.mb;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.mb.BusImgStorageBean;

/**
 * 
* @ClassName: BusImgStorageDao 
* @Description: TODO 插入图片路径Dao接口
* @date 2016年11月18日 下午2:09:37 
*
*/
public interface BusImgStorageDao {
	
	//保存图片信息
    int insertImgData(BusImgStorageBean imgBean);
    
    //查询图片信息
    BusImgStorageBean selectImgData(@Param("busId") String busId,@Param("busType") int busType);
}
