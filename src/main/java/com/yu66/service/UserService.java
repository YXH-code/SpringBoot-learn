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
    public String showNameById(int id);
    public List<User> showAllUser();

    public String insertUser();
}
