package com.yu66.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: 用户登录表实体类
 * @author: 俞先浩
 * @create: 2021-02-23 13:31
 **/
@Entity
@Table(name = "user")
public class User {
    @Id
    int id;
    String username;
    String password;

    public User(){

    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
