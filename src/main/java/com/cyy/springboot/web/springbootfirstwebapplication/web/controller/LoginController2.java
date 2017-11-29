package com.cyy.springboot.web.springbootfirstwebapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController2 {
	
	@RequestMapping("/login2")
	@ResponseBody
	public String loginMessage() {
		return "Hello World 2nd test";
	}
}