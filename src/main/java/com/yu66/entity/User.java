package com.yu66.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * @description: 用户表实体类
 * @author: 俞先浩
 * @create: 2021-02-08 10:17
 **/
@Entity
public class User {

    @Id
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String user_name;

    @NotBlank(message = "密码不能为空")
    @Length(min = 3, max = 8, message = "密码长度要求3到8之间。")
    private String password;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0,message = "年龄要>0")
    @Max(value = 100,message = "年龄要<100")
    private Integer age;

//    @Email(message = "邮箱格式错误")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "email格式有误")
    private String email;

    public User() {
    }

    public User(int id, String user_name, String password, String name, int age, String email) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
