package com.configureone.todos.webservices.restfulwebservices.controller;

import com.configureone.todos.webservices.restfulwebservices.model.Todo;
import com.configureone.todos.webservices.restfulwebservices.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

  @Autowired private TodoService todoService;

  @GetMapping("/users/{userName}/todos")
  public List<Todo> getAllTodos(@PathVariable String userName) {
    return todoService.findAll();
  }

  @GetMapping("/users/{userName}/todos/{id}")
  public Todo getTodo(@PathVariable String userName, @PathVariable long id) {
    return todoService.findById(id);
  }

  @DeleteMapping("/users/{userName}/todos/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable long id) {
    ResponseEntity responseEntity = ResponseEntity.notFound().build();
    Todo todo = todoService.deleteById(id);
    if (null != todo) {
      responseEntity = ResponseEntity.noContent().build();
    }
    return responseEntity;
  }

  @PutMapping("/users/{userName}/todos/{id}")
  public ResponseEntity<Todo> updateTodo(
      @PathVariable String userName, @PathVariable long id, @RequestBody Todo todo) {
    Todo updatedTodo = todoService.saveTodo(todo);
    return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
  }

  @PostMapping("/users/{userName}/todos")
  public ResponseEntity<Void> saveTodo(@PathVariable String userName, @RequestBody Todo todo) {
    Todo createdTodo = todoService.saveTodo(todo);

    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdTodo.getId())
            .toUri();

    return ResponseEntity.created(uri).build();
  }
}
