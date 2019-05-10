package com.easyhome.lbsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.easyhome.lbsService.po.Coordinate;
import com.easyhome.utils.SslUtil;
import com.easyhome.utils.Util;

@Service("lBSService")
public class LBSServiceImpl implements LBSService {
	Log log = LogFactory.getLog(LBSServiceImpl.class);

	public Coordinate getCoordinate(String address, String city) {
		Coordinate coordinate = new Coordinate(-1d, -1d);
		log.info("获取地址坐标:address=" + address + ",city=" + city);
		if (!Util.isEmpty(address)) {
			if (city == null)
				city = "";
			try {
				String response = SslUtil.getRequest(LBSConfig.LOCATION_URL
						+ "?key=" + LBSConfig.key + "&address=" + address
						+ "city=" + city, 6000);
				log.info("获取地址坐标结果:" + response);
				JSONObject json = JSONObject.fromObject(response);
				int status = json.getInt("status");
				int count = json.getInt("count");
				if (LBSConfig.LBS_STATUS_OK == status && count > 0) {
					// 成功
					JSONArray geocodes = json.getJSONArray("geocodes");
					JSONObject geocode = geocodes.getJSONObject(0);
					String location = geocode.getString("location");
					String[] locs = location.split(",");
					coordinate.setLon(Double.valueOf(locs[0]));
					coordinate.setLat(Double.valueOf(locs[1]));
					// 设置配置的签到范围
					String configDis = Util.getProperty("configDis");
					if (!Util.isEmpty(configDis)
							&& StringUtils.isNumeric(configDis)) {
						coordinate.setConfigDis(Integer.valueOf(configDis));
					}
				} else {
					// 失败
					log.info("根据地址不能获取地图位置:" + response);
				}
			} catch (Exception e) {
				log.error("获取地址坐标异常", e);
			}

		}
		return coordinate;
	}

	public double distance(Coordinate coordinate1, Coordinate coordinate2) {
		Double lat1 = coordinate1.getLat();
		Double lon1 = coordinate1.getLon();
		Double lat2 = coordinate2.getLat();
		Double lon2 = coordinate2.getLon();
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (lon1 - lon2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2
				* R
				* Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
						* Math.cos(lat2) * sb2 * sb2));
		return d;
	}
}
