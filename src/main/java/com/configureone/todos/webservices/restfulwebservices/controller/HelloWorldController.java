package com.configureone.todos.webservices.restfulwebservices.controller;

import com.configureone.todos.webservices.restfulwebservices.model.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {
  @GetMapping(path = "/hello-world")
  String helloWorld() {
    return "Hello World";
  }

  @GetMapping(path = "/hello-world-bean")
  HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello World Bean");
  }

  @GetMapping(path = "/hello-world/path-variable/{name}")
  HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    //        throw new RuntimeException("Something went wrong");
    return new HelloWorldBean(String.format("Hello World, %s", name));
  }
}
