package com.configureone.todos.webservices.restfulwebservices.service;

import com.configureone.todos.webservices.restfulwebservices.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

  private static List<Todo> todos = new ArrayList<>();
  private static int todoCounter = 0;

  static {
    todos.add(new Todo(todoCounter++, "in28minutes", "Learn to Dance 2", new Date(), false));
    todos.add(
        new Todo(todoCounter++, "in28minutes", "Learn about Microservices 3", new Date(), false));
    todos.add(new Todo(todoCounter++, "in28minutes", "Learn about Angular", new Date(), false));
  }

  public List<Todo> findAll() {
    return todos;
  }

  public Todo deleteById(long id) {
    Todo found = null;
    Todo todo = findById(id);
    if (null != todo) {
      todos.remove(todo);
      found = todo;
    }
    return found;
  }

  public Todo findById(long id) {
    Todo found = null;
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        found = todo;
      }
    }
    return found;
  }
}
