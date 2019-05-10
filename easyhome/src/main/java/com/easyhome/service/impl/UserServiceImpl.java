package com.easyhome.service.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyhome.dao.ForemanDao;
import com.easyhome.dao.TbAppUserMapper;
import com.easyhome.dao.TbMasterMapper;
import com.easyhome.dao.UserDao;
import com.easyhome.po.Master;
import com.easyhome.po.TbAppUser;
import com.easyhome.po.TbAppUserExample;
import com.easyhome.po.TbMaster;
import com.easyhome.po.TbMasterExample;
import com.easyhome.po.User;
import com.easyhome.po.TbAppUserExample.Criteria;
import com.easyhome.service.UserService;
import com.easyhome.utils.MD5;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;

@Service("userService")
public class UserServiceImpl implements UserService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Resource
	private UserDao userDao;
	@Resource
	private ForemanDao foremanDao;
	@Autowired
	private TbAppUserMapper tbAppUserMapper;
	@Autowired
	private TbMasterMapper tbMasterMapper;

	@Override
	public BaseResponse checkLogin(String phone, String password) {
		User user = null;
		Master master = null;
		BaseResponse response = new BaseResponse();
		// 用户名和密码检查
		try {
			if (null == phone || "".equals(phone.trim())) {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("请输入用户名");
			} else {
				user = userDao.findByPhone(phone);
				if (user != null) {// 不为空 账号存在
					String pass_word = userDao.findPasswordByPhone(phone);
					String md5_pwd = MD5.MD5Encode(password).toUpperCase();
					// 判断密码是否正确
					if (md5_pwd.equals(pass_word)) {
						// 密码正确，可以登录
						int userType = user.getUserType();
						// 普通技师登录
						if (userType == 1 || userType == 2) {
							master = userDao.findMaster(user.getMasterId());
							user.setPlatFormId(master.getPlatFormId());
							user.setPlatFormName(master.getPlatFormName());
							} else if (userType == 3) {
								Integer tag=userDao.findTag(phone);
								if(tag==0){
								String workerId = user.getMasterId();
								// 查询leaderID
								String leaderId = userDao.findLeaderId(workerId);
								master = userDao.findMaster(leaderId);
								user.setWorkerId(workerId);
								user.setMasterId(leaderId);
								user.setPlatFormId(master.getPlatFormId());
								user.setPlatFormName(master.getPlatFormName());
							}else{
								response.setReturnCode(ReturnCode.STATUS_400);
								response.setInfo("账号不存在，请检查后重新输入");
								logger.info("账号不存在");
								return response;
							}
						}
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setInfo(ReturnCode.OK);
						response.setData(user);
						logger.info("登陆成功");
					} else {
						response.setReturnCode(ReturnCode.STATUS_400);
						response.setInfo("密码错误");
						logger.info("密码错误");
					}
				} else {
					// 为空情况
					response.setReturnCode(ReturnCode.STATUS_400);
					response.setInfo("账号未注册");
					logger.info("账号未注册");
				}
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("数据获取异常！", e);
		}
		return response;
	}

	/**
	 * 修改密码
	 */
	public BaseResponse ModifyPassword(String fid, String oldpassword, String password) {
		BaseResponse response = new BaseResponse();
		try {
			String pwd = userDao.findPassword(fid);
			if (pwd.equals(MD5.MD5Encode(oldpassword).toUpperCase())) {

				String md5_pwd = MD5.MD5Encode(password).toUpperCase();
				userDao.updatePassword(fid, md5_pwd);
				response.setReturnCode(ReturnCode.STATUS_201);
				response.setInfo("修改密码成功！");
				logger.info("修改密码成功!");
			} else {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("您输入的密码有误，请重新输入");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据获取异常", e);
		}
		return response;
	}

	/**
	 * 忘记密码
	 */
	@Override
	public BaseResponse AlterPassword(String phone, String password, String captcha) {
		BaseResponse response = new BaseResponse();
		try {
			String code = userDao.findCode(phone);
			Pattern p = Pattern.compile("(\\d+)");
			Matcher m = p.matcher(code);
			if (m.find()) {
				code = m.group(1);
				System.out.println(m.group(1));
			}
			if (code.equals(captcha)) {
				String md5_pwd = MD5.MD5Encode(password).toUpperCase();
				userDao.updatePasswordByPhone(phone, md5_pwd);
				response.setReturnCode(ReturnCode.STATUS_201);
				response.setInfo("密码修改成功");
				logger.info("密码修改成功");
			} else {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("验证码输入有误，请重新输入");
				logger.error("验证码不正确");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据获取异常", e);
		}
		return response;
	}

	@Override
	public Map<String,String> findMasterIdByPhone(String phone) {
		List<Map<String,String>> list = userDao.findMasterIdByPhone(phone);
		try {
			if(list!=null && list.size()==1){
				return list.get(0);
			}
		} catch (Exception e) {
			logger.error("查询APP用户数据异常", e);
		}
		return null;
	}

	@Override
	public TbAppUser findTbAppUserByPhone(String phone) {
		if(phone!=null && !"".equals(phone)){
			TbAppUserExample example = new TbAppUserExample();
			Criteria criteria = example.createCriteria();
			criteria.andPhoneEqualTo(phone);
			List<TbAppUser> list = tbAppUserMapper.selectByExample(example);
			if(list!=null && list.size()==1){
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public TbMaster findMasterByPhone(String phone) throws Exception {
		
		//声明过程变量
		TbMasterExample example = null;
		com.easyhome.po.TbMasterExample.Criteria criteria = null;
		List<TbMaster> list = null;
		
		try {
			if(phone!=null && !"".equals(phone)){
				
				//查询条件设置
				example = new TbMasterExample();
				criteria = example.createCriteria();
				criteria.andPhoneEqualTo(phone);
				
				//执行查询
				list = tbMasterMapper.selectByExample(example);
				
				//查询结果输出
				if(list!=null && list.size()==1){
					return list.get(0);
				}else{
					return null;
				}
			}
		} finally { //销毁过程数据
			example = null;
			criteria = null;
			list = null;
		}
		return null;
	}
}