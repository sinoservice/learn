package app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzTest {
@SuppressWarnings("unchecked")	
public static void main(String[] args) {
	System.out.println("加载配置文件开始：.......");
	//ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring-mvc.xml","classpath:spring-quartz.xml");
	ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring-mvc.xml");
	System.out.println(".......");
	System.out.println(applicationContext.getBean("GetMessageService"));
	System.out.println("加载配置文件结束：.......");
}
}
