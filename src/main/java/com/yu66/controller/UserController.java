package com.yu66.controller;

import com.yu66.entity.User;
import com.yu66.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @program: springboot-learn
 * @description: 用户控制器
 * @author: 俞先浩
 * @create: 2021-02-07 10:17
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/insertById")
    public String insertById(int id,String user_name,String password,String name){
        userService.insertById(id,user_name,password,name);
        return "save success";
    }

    @GetMapping("/deleteById")
    public String deleteById(int id){
        userService.deleteById(id);
        return "delete success";
    }

    @GetMapping("/update")
    public Optional<User> update(int id,String user_name,String password,String name){
        Optional<User> user = userService.update(id, user_name, password, name);
        return user;
    }

    @GetMapping("/showById")
    public Optional<User> showById(int id){
        Optional<User> user = userService.showById(id);
        return user;
    }

    @GetMapping("/showNameById")
    public String showNameById(int id){
        String name = userService.showNameById(id);
        return name;
    }

    @GetMapping("/showAll")
    public List<User> showAll(){
        List<User> users = userService.showAllUser();
        return users;
    }

}
