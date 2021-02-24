package com.yu66.controller;

import com.yu66.entity.Customer;
import com.yu66.result.Result;
import com.yu66.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * @description: 用户登录的控制器
 * @author: 俞先浩
 * @create: 2021-02-23 13:33
 **/

@RestController
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody Customer requestcustomer, HttpSession session) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestcustomer.getUsername();
        username = HtmlUtils.htmlEscape(username);

        Customer customer = customerService.get(requestcustomer.getUsername(), requestcustomer.getPassword());
        if (null == customer) {
            return new Result(400);
        } else {
            session.setAttribute("customer", customer);
            return new Result(200);
        }
    }
}
