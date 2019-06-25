package com.configureone.todos.webservices.restfulwebservices.controller;

import com.configureone.todos.webservices.restfulwebservices.model.Todo;
import com.configureone.todos.webservices.restfulwebservices.model.TodoJpaRepository;
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
public class TodoJpaController {

  @Autowired private TodoService todoService;

  @Autowired
  private TodoJpaRepository todoJpaRepository;

  @GetMapping("/jpa/users/{userName}/todos")
  public List<Todo> getAllTodos(@PathVariable String userName) {
    return todoJpaRepository.findByUsername(userName);
  }

  @GetMapping("/jpa/users/{userName}/todos/{id}")
  public Todo getTodo(@PathVariable String userName, @PathVariable Long id) {
    return todoJpaRepository.findById(id).get();
  }

  @DeleteMapping("/jpa/users/{userName}/todos/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable Long id) {
    todoJpaRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/jpa/users/{userName}/todos/{id}")
  public ResponseEntity<Todo> updateTodo(
      @PathVariable String userName, @PathVariable Long id, @RequestBody Todo todo) {
    todo.setUsername(userName);
    Todo updatedTodo = todoJpaRepository.save(todo);
    return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
  }

  @PostMapping("/jpa/users/{userName}/todos")
  public ResponseEntity<Void> createTodo(@PathVariable String userName, @RequestBody Todo todo) {
    todo.setUsername(userName);
    Todo createdTodo = todoJpaRepository.save(todo);

    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdTodo.getId())
            .toUri();

    return ResponseEntity.created(uri).build();
  }
}
