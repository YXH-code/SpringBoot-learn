package com.yu66.controller;

import com.yu66.dao.UserDao;
import com.yu66.entity.User;
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
    private UserDao userDao;

    @GetMapping("/show")
    public Optional<User> show(int id){
        Optional<User> user = userDao.findById(id);
        return user;
    }

    @GetMapping("/showAll")
    public List<User> showAll(){
        List<User> users = userDao.findAll();
        return users;
    }

    @GetMapping("/showName")
    public String showName(int id){
        Optional<User> user = userDao.findById(id);
        User newUser = user.get();
        String name = newUser.getName();
        return name;
    }

    @GetMapping("/delete")
    public String delete(int id){
        userDao.deleteById(id);
        return "delete success";
    }

    @GetMapping("/save")
    public String save(int id,String user_name,String password,String name){
        User user = new User();
        user.setId(id);
        user.setUser_name(user_name);
        user.setPassword(password);
        user.setName(name);
        userDao.save(user);
        return "save success";
    }

    @GetMapping("/update")
    public Optional<User> update(int id,String user_name,String password,String name){
        Optional<User> user = userDao.findById(id);
        User newUser = user.get();
        newUser.setUser_name(user_name);
        newUser.setPassword(password);
        newUser.setName(name);
        userDao.save(newUser);
        Optional<User> optional = userDao.findById(id);
        return optional;
    }

}
