package com.yu66.controller;

import com.yu66.entity.Customer;
import com.yu66.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * @description: 用户登录的控制器
 * @author: 俞先浩
 * @create: 2021-02-23 13:33
 **/

@RestController
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody Customer customer) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = customer.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", customer.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
