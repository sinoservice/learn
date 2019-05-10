package app;

import org.junit.Test;

import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.Util;

public class TbOrder {
	final String token = "";

	@Test
	public void test() {
		String ApiUrl = Util.getProperty("ApiUrl");
		String str = ApiUrl + "OCP/GetAppointedDate?token=" + token;

		String issueId = "EC00244400";
		String AppointedDate = "2017-01-10";
		String url = str + "&issueId=" + issueId + "&AppointedDate=" + AppointedDate;

		String result = HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
		System.out.println(result);
	}

	@Test
	public void test1() {
		String ApiUrl = Util.getProperty("ApiUrl");
		String str = ApiUrl + "OCP/GetServiceStartDate?token=" + token;
		String issueId = "EC00244400";
		String ServiceStartDate = "2017-01-10";
		String url = str + "&issueId=" + issueId + "&ServiceStartDate=" + ServiceStartDate;
		System.out.println("url:----" + url.substring(62));
		String result = HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
		System.out.println(result);
	}

	@Test
	public void testStr() throws Exception {

		String issueId = "EC00244400";
		String item_No = "1";
		String serviceEndDate = "2017-02-21";
		String defect = "局部漏水";
		String scheme = "替换";
		String is_quality = "N";
		String is_warranty = "Y";
		String is_charge = "1";
		String is_confirm_sku = "FFAS7125-001040BC0";
		String Spare = "22";
		String transportation = "11";
		String Artificial = "44";
		String engineer = "张三";
		String remark = "部分完工";
		String visite_time = "2017-01-19";
		String defect_type = "99";
		String defect_msg = "11";
		String picture = "123,1,1,2";
		String FAILURE_REASON = "工程师忘记带配件";
		String ApiUrl = Util.getProperty("ApiUrl");
		String str = ApiUrl + "OCP/GetFinishedWorkData?token=" + token;
		String url = str + "&issueId=" + issueId + "&item_No=" + item_No + "&serviceEndDate=" + serviceEndDate
				+ "&defect=" + defect + "&scheme=" + scheme + "&is_quality=" + is_quality + "&is_warranty="
				+ is_warranty + "&is_charge=" + is_charge + "&is_confirm_sku=" + is_confirm_sku + "&Spare=" + Spare
				+ "&transportation=" + transportation + "&Artificial=" + Artificial + "&engineer=" + engineer
				+ "&remark=" + remark + "&visite_time=" + visite_time + "&defect_type=" + defect_type + "&defect_msg="
				+ defect_msg + "&picture=" + picture + "&FAILURE_REASON=" + FAILURE_REASON;
		System.out.println(url);
		String result = HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
		System.out.println(result);
	}

	@Test
	public void test2() throws Exception {

		String EC_NO = "EC00244400";
		String Content = "淘宝订单号";
		String ConsumerName = "张三";
		String Mobile = "15200133326";
		String Province = "北京";
		String City = "北京";
		String District = "十里河";
		String Address = "地铁";
		String InstallDate = "2017-01-19";
		String BarCode = "1221";
		String serviceEndDate = "2017-01-19";
		String engineer = "张三，15290566401";
		String remark = "部分完工";
		String visite_time = "2017-01-19";
		String picture = "123,1,1,2";
		String Verification_ID = "AD212131313";
		String Qty = "3";
		String SKU = "132142432121313131";
		String ApiUrl = Util.getProperty("ApiUrl");
		String str = ApiUrl + "OCP/GetFinishedWorkData?token=";
		String url = str + "&EC_NO=" + EC_NO + "&Content=" + Content + "&ConsumerName=" + ConsumerName + "&Mobile="
				+ Mobile + "&Province=" + Province + "&City=" + City + "&District=" + District + "&Address=" + Address
				+ "&InstallDate=" + InstallDate + "&BarCode=" + BarCode + "&serviceEndDate=" + serviceEndDate
				+ "&engineer=" + engineer + "&engineer=" + engineer + "&remark=" + remark + "&visite_time="
				+ visite_time + "&picture=" + picture + "&Verification_ID=" + Verification_ID + "&Qty=" + Qty + "&SKU="
				+ SKU;
		System.out.println(url);
		String result = HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
		System.out.println(result);
	}
}
