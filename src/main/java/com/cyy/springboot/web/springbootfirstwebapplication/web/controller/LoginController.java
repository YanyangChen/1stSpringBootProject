package com.cyy.springboot.web.springbootfirstwebapplication.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cyy.springboot.web.springbootfirstwebapplication.web.service.LoginService;
// /login => "Hello World"
@Controller
@SessionAttributes("name")
public class LoginController {
	
	//Injected automatically
	@Autowired  //dependent injection
	LoginService loginservice; //= new LoginService();
	//MODEL MVC - model view controller
	//model is used to pass data from controller to view(jsp)
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
//	@ResponseBody
	public String showLoginMessage(ModelMap model) {
		model.put("name", "cyy");
//		System.out.println("name is " + name);
		
		return "welcome";
	
	}
	
	
//	@RequestMapping(value= "/login", method = RequestMethod.POST)
////	@ResponseBody
//	public String showWelcomeMessage(ModelMap model, @RequestParam String name, @RequestParam String password) {
//		boolean isValidUser = loginservice.validateUser(name, password);
//		
//		if(!isValidUser)  
//			{
//			
//			model.put("errormessage", "invalid credentials");
//			return "login";}
//		model.put("name", name);
//		model.put("password", password);
////		System.out.println("name is " + name);
//		return "welcome";
//	}
}

