package com.yu66.controller;

import com.yu66.entity.User;
import com.yu66.result.Result;
import com.yu66.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * @description: 用户登录控制器
 * @author: 俞先浩
 * @create: 2021-02-23 13:33
 **/

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requestuser, HttpSession session) {

        User user = userService.get(requestuser.getUsername(), requestuser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}
