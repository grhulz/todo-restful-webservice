package com.configureone.todos.webservices.restfulwebservices.controller;

import com.configureone.todos.webservices.restfulwebservices.model.BasicAuth;
import com.configureone.todos.webservices.restfulwebservices.model.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthController {
  @GetMapping(path = "/basicauth")
  BasicAuth helloWorldBean() {
    return new BasicAuth("You are authenticated");
  }
}
