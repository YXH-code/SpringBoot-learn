package com.yu66.service;

import com.yu66.entity.User;

public interface UserService {
    public boolean isExist(String username);
    public User getByName(String username);
    public User get(String username, String password);
    public void add(User user);
}
