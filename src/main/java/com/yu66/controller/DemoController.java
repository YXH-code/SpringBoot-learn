package com.yu66.controller;


import com.yu66.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 对象封装案例
 * @author mohaijiang
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {


    /**
     *
     * /demo/user?id=1&name=zhangsan
     * 测试查询的对象封装
     * @return
     */
    @GetMapping(value = "/user")
    public String testGetWithParam(User user, HttpServletRequest req){
        System.out.println(user.getId());
        System.out.println(user.getName());
        return user.getId()+"---"+user.getName();
    }

    /**
     * /demo/user
     * id=1&name=lisi
     *
     * @return
     */
    @PostMapping(value = "/user")
    public String testPostWithForm(User user, HttpServletRequest req){
        System.out.println(user.getId());
        System.out.println(user.getName());
        return user.getId()+"---"+user.getName();
    }


    /**
     * /demo/user
     * {
     *     "id": 123,
     *     "name": "wangwu"
     * }
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user-with-body")
    public String testPostWithBody(@RequestBody User user, HttpServletRequest req){
        System.out.println(user.getId());
        System.out.println(user.getName());
        return user.getId()+"---"+user.getName();
    }
}
