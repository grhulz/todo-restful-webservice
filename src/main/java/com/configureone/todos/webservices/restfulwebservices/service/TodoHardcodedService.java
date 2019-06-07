package com.configureone.todos.webservices.restfulwebservices.service;

import com.configureone.todos.webservices.restfulwebservices.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todoCounter = 0;

    static {
        todos.add(new Todo(todoCounter++, "in28minutes", "Learn to Dance", new Date(), false));
        todos.add(new Todo(todoCounter++, "in28minutes", "Learn about Microservices", new Date(), false));
        todos.add(new Todo(todoCounter++, "in28minutes", "Learn about Angular", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }
  }
