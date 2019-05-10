package easyhome;

import java.util.UUID;

import javax.annotation.Resource;

import com.easyhome.dao.ForemanDao;
import com.easyhome.utils.MD5;
import com.easyhome.utils.Util;

public class CheckCode {
	@Resource
	private ForemanDao foremanDao;
	public static void main(String[] args) {
	
//		UUID uuid  =  UUID.randomUUID(); 
		String s = UUID.randomUUID().toString().replace("-", "");
		String a= "123456";
		String b=MD5.MD5Encode(a).toUpperCase();
				//a=UUID.randomUUID().toString().substring(8, 24);
	System.out.println(s);
	System.out.println("a"+":"+b);
	String phon="15625252505";
	boolean phone=Util.isMobile(phon);
	System.out.println(phone+"--------");
	System.out.println((int)((Math.random()*9+1)*100000)); 
//	Calendar c=Calendar.getInstance();
//	int month=(c.get(c.MONTH))+1;
//			
//	System.out.println(month);
	String reg="/^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]){6,20}$/";
	String password="1,./2ass@_+[]";
	boolean pwd=Util.isPassword(password);
	System.out.println(pwd);
	
	}
}