package org.module.sysadmin;

import java.util.List;

import org.springframework.context.ApplicationContext;

import org.module.sysadmin.model.SecUser;
import org.module.sysadmin.service.UserService;

public class UserServiceTest {
	ApplicationContext applicationContext;
	static UserService userService;
	
	public UserServiceTest(){
		applicationContext = SpringUtil.getApplicationContext();
		userService = (UserService) applicationContext.getBean("userService");
	}
	
	public void getAllFunction(){
		SecUser secUser =  userService.getNewUser();
		List<SecUser> getAllUsers =  userService.getAllUsers();
		List<SecUser> getUserLikeLoginNames =  userService.getUserLikeLoginNames("admin");
		List<SecUser> getUserLikeLastNames =  userService.getUserLikeLastNames("Visor");
		List<SecUser> getUserLikeEmails =  userService.getUserLikeEmails("admin@web.de");
		
		secUser.getClass();
		getAllUsers.size();
		getUserLikeLoginNames.size();
		getUserLikeLastNames.size();
		getUserLikeEmails.size();
	}
	
	public static void main(String[]arguments){
		UserServiceTest userServiceTest = new UserServiceTest();
		userServiceTest.getAllFunction();
	}
}