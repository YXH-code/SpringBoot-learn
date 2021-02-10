package com.yu66.service;

import com.yu66.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public String insertById(int id,String user_name,String password,String name);

    public String deleteById(int id);

    public Optional<User> update(int id,String user_name,String password,String name);

    public Optional<User> showById(int id);
    public List<User> findByName(String name);
    public List<User> showAllUser();

    //测试回滚
    public String insertUser();

    //自定义简单查询
    public List<User> findByNameAndPassword(String name,String password);
    public List<User> findByNameOrPassword(String name,String password);
}
