package easyhome.web.service;

import org.junit.Test;

public class MsgTest {

	@Test
	public void testName() throws Exception {
		String success = "【居然之家】您好，您在伊奈家居旗舰店购买的产品已安排朱海征师傅（15110272604）上门测量/安装/维修，请提前48小时联系师傅预约，全国服务热线4006120122。";
		
		String fail = "【居然之家】您好，您在伊奈家居旗舰店购买的产品已成功预约1月3日上午测量/安装/维修，请您向师傅出示签到码9263，全国服务热线4006120122。";
		String review = "【居然之家】您好，感谢您对本次测量/安装/维修服务的满意度评价，全国服务热线4006120122，祝您生活愉快！";
		System.out.println(success.length());
		System.out.println(fail.length());
		System.out.println(review.length());
	}
}
