package com.cyy.springboot.web.springbootfirstwebapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// /login => "Hello World"
@Controller
public class LoginController {
	
	//MODEL MVC - model view controller
	//model is used to pass data from controller to view(jsp)
	
	@RequestMapping("/login")
//	@ResponseBody
	public String loginMessage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		System.out.println("name is " + name);
		return "login";
	}
}

