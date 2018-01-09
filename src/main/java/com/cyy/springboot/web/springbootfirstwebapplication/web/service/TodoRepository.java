package com.cyy.springboot.web.springbootfirstwebapplication.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyy.springboot.web.springbootfirstwebapplication.web.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	List<Todo> findByUser(String user);
}
