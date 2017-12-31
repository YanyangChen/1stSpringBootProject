package com.cyy.springboot.web.springbootfirstwebapplication.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cyy.springboot.web.springbootfirstwebapplication.web.service.TodoService;
import com.cyy.springboot.web.springbootfirstwebapplication.web.model.Todo;
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
	
	
	@RequestMapping(value= "/add-todo", method = RequestMethod.GET)
//	Bean -> Form
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0,(String)model.get("name"),"Defaule description",new Date(), false));
		return "todo";
	
	}
	
	@RequestMapping(value= "/delete-todo", method = RequestMethod.GET)
//	@ResponseBody
	public String deleteTodo(@RequestParam int id) {
		todoservice.deleteTodo(id);
		return "redirect:/list-todos";
	
	}
	
//	@RequestMapping(value= "/add-todo", method = RequestMethod.POST)
////	@ResponseBody
//	public String addTodo(ModelMap model, @RequestParam String desc) {
//		todoservice.addTodo((String)model.get("name"), desc, new Date(), false);
//		return "redirect:/list-todos";
//	
//	}
	
	@RequestMapping(value= "/add-todo", method = RequestMethod.POST)
//@ResponseBody
public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors())
		{
			return "todo";
			
		}
	todoservice.addTodo((String)model.get("name"), todo.getDesc(), new Date(), false);
	return "redirect:/list-todos";

}
	
}

