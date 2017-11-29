package com.cyy.springboot.web.springbootfirstwebapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// /login => "Hello World"
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	@ResponseBody
	public String loginMessage() {
		return "Hello World modified";
	}
}
