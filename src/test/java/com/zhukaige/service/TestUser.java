package com.zhukaige.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhukaige.entity.User;

public class TestUser  extends TestBase{
	
	@Autowired
	UserService userService;
	
	@Test
	public void testRegister() {
		User user = new User();
		user.setUsername("zhenhuaiwei");
		user.setPassword("123456");
		
		userService.register(user);
		
		
		User xiaojian = new User();
		xiaojian.setUsername("xiaojian");
		xiaojian.setPassword("123456");
		
		userService.register(xiaojian);
		
		
		
		
		
	}

}
