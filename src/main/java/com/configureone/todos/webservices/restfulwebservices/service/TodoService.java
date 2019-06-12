package com.configureone.todos.webservices.restfulwebservices.service;

import com.configureone.todos.webservices.restfulwebservices.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

  private static List<Todo> todos = new ArrayList<>();
  private static int todoCounter = 1;

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

  public Todo saveTodo(Todo todo) {
    if (todo.getId() == -1 || todo.getId() == 0) {
      todo.setId(todoCounter++);
      todos.add(todo);
    } else {
      deleteById(todo.getId());
      todos.add(todo);
    }
    return todo;
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
