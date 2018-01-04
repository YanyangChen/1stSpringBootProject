package com.cyy.springboot.web.springbootfirstwebapplication.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	//MODEL MVC - model view controller
	//model is used to pass data from controller to view(jsp)
	
	@RequestMapping(value= "/list-todos", method = RequestMethod.GET)
//	@ResponseBody
	public String showTodos(ModelMap model) {
		String namex = getLoggedInUserName(model);
		model.put("todos", todoservice.retrieveTodos(namex));
		return "list-todos";
	
	}

	private String getLoggedInUserName(ModelMap model) {
		return (String)model.get("name");
	}
	
	
	
	@RequestMapping(value= "/add-todo", method = RequestMethod.GET)
//	Bean -> Form
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0,getLoggedInUserName(model),"Defaule description",new Date(), false));
		return "todo";
	
	}
	
	@RequestMapping(value= "/update-todo", method = RequestMethod.GET)
//	@ResponseBody
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoservice.retrieveTodos(id);
		model.put("todo", todo);
		return "todo";
	
	}
	
	@RequestMapping(value= "/update-todo", method = RequestMethod.POST)
//	@ResponseBody
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors())
		{
			return "todo";
			
		}
		
		todo.setUser(getLoggedInUserName(model));
		
		todoservice.updateTodo(todo);
		return "redirect:/list-todos";
		
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
	todoservice.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
	return "redirect:/list-todos";

}
	
}

