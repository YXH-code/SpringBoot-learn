package com.yu66.Controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class UserController {
    @RequestMapping("/{name}")
    String sayHello(@PathVariable String name) {
        return "hello," + name + "!";
    }
}
