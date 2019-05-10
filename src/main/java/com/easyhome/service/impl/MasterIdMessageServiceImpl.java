package com.easyhome.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.easyhome.dao.TbWorkOrderBackupDao;
import com.easyhome.po.TbWorkOrderBackup;
import com.easyhome.service.MasterIdMessageService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;

@Service("masterIdMessageService")
public class MasterIdMessageServiceImpl implements MasterIdMessageService {
	
	@Resource
	private TbWorkOrderBackupDao TbWorkOrderBackupMapper;
	Log log = LogFactory.getLog(MasterIdMessageServiceImpl.class);
	public BaseResponse findWorkOrder( String masterId, Integer pagesize, Integer pageIndex) {
		BaseResponse response = new BaseResponse();
		List<TbWorkOrderBackup> result = null;
		
		if(masterId ==null||"".equals(masterId)){
			response.setInfo(ReturnCode.NO_MASTERID);
			response.setReturnCode(ReturnCode.STATUS_425);
			result = new ArrayList<TbWorkOrderBackup>();
			response.setData(result);
			return response;
		
		}
		
		if(pagesize ==null ||"".equals(pagesize)){
			response.setInfo("请确定每页要查多少条？");
			response.setReturnCode(ReturnCode.STATUS_424);
			result = new ArrayList<TbWorkOrderBackup>();
			response.setData(result);
			return response;
		}
		
		if(pageIndex ==null ||"".equals(pageIndex)){
			response.setInfo("请确定从第几页开始查询？");
			response.setReturnCode(ReturnCode.STATUS_423);
			result = new ArrayList<TbWorkOrderBackup>();
			response.setData(result);
			return response;
		}
		
		try{
			int rowStart = ((pageIndex - 1) * pagesize)+1;
			int rowEnd = pageIndex * pagesize;
			result = TbWorkOrderBackupMapper.selectByMasterId(masterId,rowStart,rowEnd);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		for (TbWorkOrderBackup tbWorkOrderBackup : result) {
//			System.out.println("xxxxx:" + tbWorkOrderBackup.getRevokeTime());
//			if(null != tbWorkOrderBackup.getRevokeTime())
//			{
//				//System.out.println("aaa:" + sdf.format(tbWorkOrderBackup.getRevokeTime()));
//				tbWorkOrderBackup.setRevokeTime(sdf.format(tbWorkOrderBackup.getRevokeTime()).toString());
//			}
//		}
			response.setData(result);
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo(ReturnCode.OK);			
			
		}catch(Exception e){
			e.printStackTrace();
			response.setReturnCode(ReturnCode.STATUS_404);
			response.setInfo("要查询的工单不存在！");
			log.error("执行上面代码出现异常",e);
			result = new ArrayList<TbWorkOrderBackup>();
			response.setData(result);
		}						
		return response;
	}

}
