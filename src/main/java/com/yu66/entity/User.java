package com.yu66.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * @program: springboot-learn
 * @description: 用户表实体类
 * @author: 俞先浩
 * @create: 2021-02-08 10:17
 **/
@Entity
public class User {

    @Id
    private int id;
    private String user_name;
    private String password;
    private String name;

    public User() {
    }

    public User(int id, String user_name, String password, String name) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
