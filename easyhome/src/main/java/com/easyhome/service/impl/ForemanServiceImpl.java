package com.easyhome.service.impl;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyhome.dao.ForemanDao;
import com.easyhome.po.Worker;
import com.easyhome.po.WorkerListResponse;
import com.easyhome.po.WorkerRequest;
import com.easyhome.po.WorkerResponse;
import com.easyhome.service.ForemanService;
import com.easyhome.utils.MD5;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;

import sun.misc.BASE64Decoder;

@Service("formanService")
@Transactional
public class ForemanServiceImpl implements ForemanService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ForemanServiceImpl.class);

	@Resource
	private ForemanDao foremanDao;

	@Override
	public BaseResponse save(String name, String phone, String passWord, String masterId) {
		BaseResponse response = new BaseResponse();
		UUID uuid = UUID.randomUUID();
		String user_fid = UUID.randomUUID().toString();
		String worker_fid = UUID.randomUUID().toString();
		try {
			if (!Util.isEmpty(name, phone, passWord, masterId)) {
				String workPhone = foremanDao.findPhone(phone);
				String md5_pwd = MD5.MD5Encode(passWord).toUpperCase();
				if (!phone.equals(workPhone)) {
					foremanDao.insertWorker(worker_fid, name, phone, masterId);
					foremanDao.insert(user_fid, name, phone, md5_pwd, worker_fid);
					response.setReturnCode(ReturnCode.STATUS_201);
					response.setInfo("添加工人成功！");
					logger.info("添加工人成功");
				} else {
					response.setReturnCode(ReturnCode.STATUS_400);
					response.setInfo("此工人已存在，请检查后重新输入");
					logger.info("工人已存在");
				}
			} else {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("请检查后重新输入");
				logger.info("添加工人失败");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("获取数据异常", e);
		}
		return response;
	}

	/**
	 * 修改工人信息
	 */
	@Override
	public BaseResponse updateWorker(String name, String phone, String passWord, String fid) {
		BaseResponse response = new BaseResponse();
		try {
			if (!Util.isEmpty(name, phone, passWord, fid)) {
				String masterId = foremanDao.findMasterId(phone);
				if (masterId == null || masterId.equals(fid)) {
					String md5_pwd = MD5.MD5Encode(passWord).toUpperCase();
					foremanDao.update(name, phone, md5_pwd, fid);
					foremanDao.updateWorker(name, phone, fid);
					response.setReturnCode(ReturnCode.STATUS_200);
					response.setInfo(ReturnCode.OK);
					logger.info("修改成功");
				} else {
					response.setReturnCode(ReturnCode.STATUS_400);
					response.setInfo("号码已存在");
					logger.info("修改用户失败，号码已存在");
				}
			} else {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("请检查后重新输入");
				logger.info("修改用户失败");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("获取数据异常", e);
		}
		return response;
	}

	/**
	 * 锁定/解锁工人
	 */
	@Override
	public BaseResponse updateLocking(String fid, String masterId, Integer locking) {
		BaseResponse response = new BaseResponse();
		Map<String, Integer> map = new HashMap<>();
		try {
			foremanDao.updateLocking(fid, masterId, locking);
			Integer workerLocking = foremanDao.findLocking(fid);
			if (1 == workerLocking) {
				map.put("locking", workerLocking);
				response.setReturnCode(ReturnCode.STATUS_201);
				response.setInfo("工人已被锁定");
				response.setData(map);
				logger.info("工人已被锁定");
			}
			if (0 == workerLocking) {
				map.put("locking", workerLocking);
				response.setReturnCode(ReturnCode.STATUS_201);
				response.setInfo("解锁成功");
				response.setData(map);
				logger.info("工人已解锁");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("获取数据异常", e);
		}
		return response;
	}

	/**
	 * 删除工人
	 */
	@Override
	public BaseResponse updateTag(String fid, String masterId) {
		BaseResponse response = new BaseResponse();
		try {
			Map<String, Integer> map = new HashMap<>();
			foremanDao.updateTag(fid, masterId);
			map.put("tag", 1);
			response.setReturnCode(ReturnCode.STATUS_201);
			response.setInfo("删除成功");
			response.setData(map);
			logger.info("删除成功");
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("获取数据异常", e);
		}
		return response;
	}

	/**
	 * 查询工人列表
	 */
	@Override
	public BaseResponse findWorker(String masterId, Integer pageIndex, Integer pageSize) {
		BaseResponse response = new BaseResponse();

		List<WorkerListResponse> workerListResponses = null;
		try {
			int rowStart = ((pageIndex - 1) * pageSize) + 1;
			int rowEnd = pageIndex * pageSize;
			List<WorkerListResponse> worker = foremanDao.findWorker(masterId, rowStart, rowEnd);
			if (worker == null) {
				workerListResponses = new ArrayList<>();
			} else {

				WorkerListResponse listResponse = null;
				workerListResponses = new ArrayList<WorkerListResponse>();
				for (WorkerListResponse work : worker) {
					listResponse = new WorkerListResponse();
					listResponse.setName(work.getName());
					listResponse.setPhone(work.getPhone());
					listResponse.setFid(work.getFid());
					listResponse.setCity(work.getCity());
					listResponse.setWorkType(work.getWorkType());
					workerListResponses.add(listResponse);
				}
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setData(workerListResponses);
				response.setInfo("查询数据成功");
				logger.info("查询数据成功");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("获取数据异常", e);
		}
		return response;
	}

	/**
	 * 完善工人信息
	 */
	@Override
	public BaseResponse insertWorkerDetile(WorkerRequest workerRequest) {
		BaseResponse response = new BaseResponse();
		try {
			//UUID uuid = UUID.randomUUID();
			//String user_fid = UUID.randomUUID().toString();
			// 对图片处理begin
			String img1 = workerRequest.getImages1();
			String img2 = workerRequest.getImages2();
			String img3 = workerRequest.getImages3();
			workerRequest.setImages1(saveImg(img1));
			workerRequest.setImages2(saveImg(img2));
			workerRequest.setImages3(saveImg(img3));
			// 对图片处理end

			/*foremanDao.updateUser(workerRequest.getFid(), workerRequest.getSex(), workerRequest.getMasterId());*/
			
			Worker worker = new Worker();
			worker.setFid(workerRequest.getFid());
			worker.setAge(workerRequest.getAge());
			worker.setSex(workerRequest.getSex());
//			worker.setPhone(workerRequest.getPhone());
			worker.setChat(workerRequest.getChat());
			worker.setIdentityCard(workerRequest.getIdentitycard());
			worker.setWorkType(workerRequest.getWorktypes());
			worker.setHaveTools(workerRequest.getTools());
			worker.setHavaInsurance(workerRequest.getInsurance());
			worker.setBankName(workerRequest.getBankname());
			worker.setBranch(workerRequest.getBranch());
			worker.setBankNumber(workerRequest.getBanknumber());
			worker.setBankAccount(workerRequest.getBankaccount());
			worker.setSosLinkMan(workerRequest.getSoslinkman());
			worker.setLinkPhone(workerRequest.getLinkphone());
			worker.setRelationship(workerRequest.getRelationship());
			worker.setImageUrl1(workerRequest.getImages1());
			worker.setImageUrl2(workerRequest.getImages2());
			worker.setImageUrl3(workerRequest.getImages3());
			worker.setRemark(workerRequest.getRemark());
			foremanDao.updateWorkerDetile(worker);
			response.setReturnCode(ReturnCode.STATUS_201);
			response.setInfo("信息保存成功");
			logger.info("信息保存成功");
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("获取数据异常", e);
		}
		return response;
	}

	/**
	 * 查询工人详细信息
	 */
	@Override
	public BaseResponse findWorkerDetile(String fid, String masterId) {
		BaseResponse response = new BaseResponse();
		try {
			WorkerResponse workerResponse = foremanDao.findWorkerDetile(fid, masterId);
			String passWord = foremanDao.findPassWord(fid);
			workerResponse.setPassWord(passWord);
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setData(workerResponse);
			response.setInfo("查询工人信息成功");
			logger.info("查询工人信息成功");
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
			logger.error("获取数据异常", e);
		}
		return response;
	}

	private String saveImg(String imgStr) {

		String Basepath = Util.getProperty("filePath");
		BASE64Decoder decoder = new BASE64Decoder();
		Calendar c = Calendar.getInstance();
		String filePath = "upload" + File.separator + c.get(Calendar.YEAR) + File.separator + (c.get(Calendar.MONTH) + 1)
				+ File.separator + c.get(Calendar.DAY_OF_MONTH) + File.separator;
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}

			File f = new File(Basepath + filePath);
			if (!f.exists()) {
				f.mkdirs();
			}
			// 生成jpeg图片
			String imgFilePath = Basepath + filePath + System.currentTimeMillis() + ".jpg";// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e) {
			logger.error("保存图片异常", e);
		}

		return filePath + System.currentTimeMillis() + ".jpg";
	}

}
