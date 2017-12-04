package com.cyy.springboot.web.springbootfirstwebapplication.web.service;

import org.springframework.stereotype.Component;

//Spring Bean
@Component
public class LoginService {

		public boolean validateUser(String userid, String password)
		{
			//dummy
			return userid.equalsIgnoreCase("cyy")
					&& password.equalsIgnoreCase("dummy");
		}
}
