package easyhome;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.dao.ForemanDao;
import com.easyhome.po.Worker;
import com.easyhome.po.oms.LoginRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class WorkerTest {
	
	@Autowired
	private ForemanDao foremanDao;
	@Test
	public void test(){
		LoginRequest request=new LoginRequest();
		request.setPhone("18510906497");
		request.setPassword("123456");
	}
	
	@Test
	public void Test1(){
//		WorkerRequest workerRequest=new WorkerRequest();
		Worker worker = new Worker();
		try {
			UUID uuid  =  UUID.randomUUID(); 
			String user_fid = UUID.randomUUID().toString();
//			worker.setMasterId("654321");
			worker.setFid("13e99277-011e-4b2e-a1b8-9f92964f4bf3");
			worker.setName("叶");
			worker.setPhone("123321");
			worker.setSex("女");
			worker.setIdentityCard("2143545314651355445");
//			worker.setBankAccount("疯狂的世界");
			worker.setBankName("中国银行");
			worker.setBankNumber("62134563322");
			worker.setSosLinkMan("蜘蛛侠");
			worker.setChat("23463456");
			worker.setLinkPhone("110");
//			worker.setServiceProvinceDisplay("fsd");
//			worker.setServiceCityDisplay("dfsf");
//			worker.setServiceDistrictDisplay("fssdf");
//			workerRequest.setMasterFrom("自有");
			worker.setBranch("北京银行");
			worker.setRelationship("sdf");
			worker.setWorkType("花洒");
//			worker.setServiceProvince("河北");
//			worker.setServiceCity("唐山");
//			worker.setServiceDistrict("唐山");
//			worker.setCreateTime(new Date());
			worker.setAge("20");
//			worker.setHaveCar("1");
			worker.setHaveTools("1");
			worker.setHavaInsurance("fd");
			worker.setRemark("121");
			worker.setImageUrl1("1");
			worker.setImageUrl2("2");
			worker.setImageUrl3("3");
//			worker.setCarType("大卡");
//			String master_fid=foremanDao.findFid(worker.getMasterId());
			foremanDao.updateWorkerDetile(worker);
//			foremanDao.insertWorkerDetile(worker);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(worker);
	}
	
//	/**
//     * 获取某月的最后一天
//     * @Title:getLastDayOfMonth
//     * @Description:
//     * @param:@param year
//     * @param:@param month
//     * @param:@return
//     * @return:String
//     * @throws
//     */
    public static String getLastDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
         
        return lastDayOfMonth;
    }
// 
//    /**
//     * @Title:main
//     * @Description:
//     * @param:@param args
//     * @return: void
//     * @throws
//     */
    @Test
    public static void main(String[] args) 
    {
        String lastDay = getLastDayOfMonth(2014,2);
        System.out.println("获取当前月的最后一天：" + lastDay);
        Double d=new Double("0.0");
        String a="123.1";
		double b=d.parseDouble(a);
		System.out.println(b);
    }
	
	@Test
	public void test2() throws Exception {
		EbTechnicianModel ebTechnicianModel=new EbTechnicianModel();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=simpleDateFormat.format(new Date());
		System.out.println(date);
		Date date1=simpleDateFormat.parse(date);
		System.out.println(date1);
		Gson gson = new GsonBuilder()  
				  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
				  .create();
		String json = gson.toJson(date1);
		System.out.println(json);
		ebTechnicianModel.setCreateTime(date1);
		ebTechnicianModel.setCreator("asdd");
		ebTechnicianModel.setEbteAccountHolder("李白");
		ebTechnicianModel.setEbteAge(25l);
		ebTechnicianModel.setEbteBankAccount("北京银行");
		ebTechnicianModel.setEbteBranchBank("十里河支行");
		ebTechnicianModel.setEbteBrandAttestationCode("12");
		ebTechnicianModel.setEbteBrandAttestationName("12");
		ebTechnicianModel.setEbteCarCode("62184256654411220");
		ebTechnicianModel.setEbteCard("41031223232454561");
		ebTechnicianModel.setEbteCarName("libai");
		ebTechnicianModel.setEbteCertifiedState(0l);
		ebTechnicianModel.setEbteCode("21231");
		ebTechnicianModel.setEbteContactNumber(15290566401l);
		ebTechnicianModel.setEbteDistributionSpace(1l);
		ebTechnicianModel.setEbteEmergencyLinkman("杜甫");
		ebTechnicianModel.setEbteEnableState(0l);
		ebTechnicianModel.setEbteEsstStationCode("21");
		ebTechnicianModel.setEbteEsstStationName("12");
		ebTechnicianModel.setEbteIsAccidentInsurance(1l);
		ebTechnicianModel.setEbteIsHasCar(1l);
		ebTechnicianModel.setEbteIsHasInstallTool(1l);
		ebTechnicianModel.setEbteIsHasTeam(1l);
		ebTechnicianModel.setEbteIsModifyPwd("0");
		ebTechnicianModel.setEbteLocation("beijing");
		ebTechnicianModel.setEbteName("李白");
		ebTechnicianModel.setEbteOpenBank("北京银行");
		ebTechnicianModel.setEbteParentName("李世民");
		ebTechnicianModel.setEbteParentWorkNo("ad121321310");
		ebTechnicianModel.setEbtePassword("123456");
		ebTechnicianModel.setEbtePhoneNo(22l);
		ebTechnicianModel.setEbtePhotoUrl1("url1");
		ebTechnicianModel.setEbtePhotoUrl2("url2");
		ebTechnicianModel.setEbtePhotoUrl3("url3");
		ebTechnicianModel.setEbteProperties("2");
		ebTechnicianModel.setEbteQq("54546545614");
		ebTechnicianModel.setEbteRelation("fdfds");
		ebTechnicianModel.setEbteName("韩信");
		ebTechnicianModel.setEbteRemark("没问题");
		ebTechnicianModel.setEbteReviewState(0l);
		ebTechnicianModel.setEbteSchedulingPlatfrom("beijing ");
		ebTechnicianModel.setEbteServiceArea("北京");
		ebTechnicianModel.setEbteServiceGrade("dfs");
		ebTechnicianModel.setEbteSex("1");
		ebTechnicianModel.setEbteSpaceSum("fds");
		ebTechnicianModel.setEbteSpaceType("fds");
		ebTechnicianModel.setEbteTeamCount("23");
		ebTechnicianModel.setEbteType(0l);
		ebTechnicianModel.setEbteVerificateCode("fds");
		ebTechnicianModel.setEbteVerificateCreateTime(new Date());
		ebTechnicianModel.setEbteVerificateInvalidTime(new Date());
		ebTechnicianModel.setEbteWorkNo("fsd");
		ebTechnicianModel.setEbteWorkType("fds");
		ebTechnicianModel.setModifier("fsd");
		ebTechnicianModel.setModifyTime(new Date());
		ebTechnicianModel.setRecStatus(1l);
		ebTechnicianModel.setRecVer(1l);
		ebTechnicianModel.setSiteCode("1312");
		ebTechnicianModel.setSiteName("天津平台");
		System.out.println(ebTechnicianModel.toString());
		
	}
 
}
