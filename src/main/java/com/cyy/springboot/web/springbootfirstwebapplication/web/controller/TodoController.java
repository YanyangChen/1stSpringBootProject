package com.cyy.springboot.web.springbootfirstwebapplication.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cyy.springboot.web.springbootfirstwebapplication.web.service.TodoService;
import com.cyy.springboot.web.springbootfirstwebapplication.web.service.LoginService;
// /login => "Hello World"
@Controller
@SessionAttributes("name")
public class TodoController {
	
	//Injected automatically
	@Autowired  //dependent injection
	TodoService todoservice; //= new LoginService();
	//MODEL MVC - model view controller
	//model is used to pass data from controller to view(jsp)
	
	@RequestMapping(value= "/list-todos", method = RequestMethod.GET)
//	@ResponseBody
	public String showTodos(ModelMap model) {
		String namex = (String)model.get("name");
		model.put("todos", todoservice.retrieveTodos(namex));
		return "list-todos";
	
	}
	
	
	
}

