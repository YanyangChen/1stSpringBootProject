package com.cyy.springboot.web.springbootfirstwebapplication.web.controller;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
import com.cyy.springboot.web.springbootfirstwebapplication.web.service.TodoRepository;
// /login => "Hello World"
@Controller
@SessionAttributes("name")

public class TodoController {
	
	//Injected automatically
//	@Autowired  //dependent injection
//	TodoService todoservice; //= new LoginService();
	
	@Autowired
	TodoRepository repository;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	//MODEL MVC - model view controller
	//model is used to pass data from controller to view(jsp)
	
	 Comparator<Todo> cii = new Comparator<Todo>(){
			
			@Override
			public int compare(Todo i,Todo j) {
				
				return -i.getId() + j.getId();
			}};
	
	@RequestMapping(value= "/list-todos", method = RequestMethod.GET)
//	@ResponseBody
	public String showTodos(ModelMap model) {
		String namex = getLoggedInUserName(model);
		model.put("todos", repository.findByUser(namex));
//		model.put("todos", todoservice.retrieveTodos(namex));
		return "list-todos";
	
	}

	private String getLoggedInUserName(ModelMap model) {
		return (String)model.get("name");
	}
	
	
	
	@RequestMapping(value= "/add-todo", method = RequestMethod.GET)
//	Bean -> Form
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0,getLoggedInUserName(model),"Default description",new Date(), false));
		return "todo";
	
	}
	
	@RequestMapping(value= "/update-todo", method = RequestMethod.GET)
//	@ResponseBody
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = repository.findById(id).get();
//		Todo todo = todoservice.retrieveTodos(id);
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
		
		repository.save(todo);
//		todoservice.updateTodo(todo);
		return "redirect:/list-todos";
		
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {

//		if(id==1)
//			throw new RuntimeException("Something went wrong");
		repository.deleteById(id);
//		todoservice.deleteTodo(id);
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
		todo.setUser(getLoggedInUserName(model));
//		List<Todo> todoss;
//		todoss = repository.findByUser(getLoggedInUserName(model));
//		todoss.sort(cii);
//		todo.setId(todoss.get(0).getId() + 1);
		repository.save(todo);
//	todoservice.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
	return "redirect:/list-todos";

}
	
}

