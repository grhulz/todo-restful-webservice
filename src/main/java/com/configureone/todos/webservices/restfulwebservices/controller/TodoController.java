package com.configureone.todos.webservices.restfulwebservices.controller;

import com.configureone.todos.webservices.restfulwebservices.model.Todo;
import com.configureone.todos.webservices.restfulwebservices.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/users/{userName}/todos")
    public List<Todo> getAllTodos(@PathVariable String userName){
        return todoHardcodedService.findAll();
    }
}
