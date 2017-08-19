package org.module.hr;

import java.util.List;

import org.module.hr.model.MstTest;
import org.module.hr.service.MstTestService;
import org.springframework.context.ApplicationContext;

public class HrTest {
	ApplicationContext applicationContext;
	static MstTestService mstTestService;
	
	public HrTest(){
		applicationContext = SpringUtil.getApplicationContext();
		mstTestService = (MstTestService) applicationContext.getBean("mstTestService");
	}
	
	public void getAllFunction(){
		List<MstTest> getAllTests =  mstTestService.getAllMstTests();

		//List<MstTest> getAllTests =  mstTestService.getByMstTestRequestMap(null);
		System.out.println("List Size Test >>>"+getAllTests.size());
	}
	
	public static void main(String[]arguments){
		HrTest hrTest = new HrTest();
		hrTest.getAllFunction();
	}
}