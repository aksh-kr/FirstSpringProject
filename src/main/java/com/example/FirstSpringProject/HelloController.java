package com.example.FirstSpringProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello() {
        return "<b>hello world</b>";
    }

    @GetMapping("/")
    public String getRoot() {
        return "Welcome Home ...";
    }

    @GetMapping("/test")
    public String getTest() {
        return "testing ... 1 2 3";
    }

}
