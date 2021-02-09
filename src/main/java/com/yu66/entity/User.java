package com.yu66.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @program: springboot-learn
 * @description: 用户表实体类
 * @author: 俞先浩
 * @create: 2021-02-08 10:17
 **/
@Entity
@Data
public class User {

    @Id
    private int id;
    private String user_name;
    private String password;
    private String name;

}
