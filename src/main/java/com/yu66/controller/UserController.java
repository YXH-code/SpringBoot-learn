package com.yu66.controller;

import com.yu66.entity.User;
import com.yu66.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * @description: 用户控制器
 * @author: 俞先浩
 * @create: 2021-02-07 10:17
 **/
@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insertById")
    public String insertById(@RequestBody User user, HttpServletRequest req){
        userService.insertById(user);
        return "insert success";
    }

    @DeleteMapping("/deleteById")
    public String deleteById(int id){
        userService.deleteById(id);
        return "delete success";
    }

    @PutMapping("/update")
    public Optional<User> update(@RequestBody User user, HttpServletRequest req){
        Optional<User> update = userService.update(user);
        return update;
    }

    @GetMapping("/showById")
    public Optional<User> showById(int id){
        Optional<User> user = userService.showById(id);
        return user;
    }

    @GetMapping("/showByName")
    public List<User> findByName(String name){
        List<User> user = userService.findByName(name);
        return user;
    }

    @GetMapping("/showAll")
    public List<User> showAll(){
        List<User> users = userService.showAllUser();
        return users;
    }

    @PostMapping("/insertUser")
    public String insertUser(){
        String string = userService.insertUser();
        return string;
    }

    @GetMapping("/findByNameAndPassword")
    public List<User> findByNameAndPassword(String name,String password){
        List<User> user = userService.findByNameAndPassword(name, password);
        return user;
    }

    @GetMapping("/findByNameOrPassword")
    public List<User> findByNameOrPassword(String name,String password){
        List<User> user = userService.findByNameOrPassword(name, password);
        return user;
    }

    @GetMapping("/findByNameStartingWith")
    public List<User> findByNameStartingWith(String firstname){
        List<User> user = userService.findByNameStartingWith(firstname);
        return user;
    }

}
