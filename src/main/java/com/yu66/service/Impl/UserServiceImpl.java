package com.yu66.service.Impl;

import com.yu66.dao.UserDao;
import com.yu66.entity.User;
import com.yu66.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 用户登录业务逻辑层实现类
 * @author: 俞先浩
 * @create: 2021-02-23 14:30
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
    * @Description: 判断用户名是否存在
    * @Param: [username]
    * @return: boolean
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    @Override
    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    /**
    * @Description: 根据用户名查询用户
    * @Param: [username]
    * @return: com.yu66.entity.User
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    @Override
    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    /**
    * @Description: 根据用户名和密码查询用户
    * @Param: [username, password]
    * @return: com.yu66.entity.User
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    @Override
    public User get(String username, String password){
        return userDao.getByUsernameAndPassword(username, password);
    }

    /**
    * @Description: 添加用户
    * @Param: [customer]
    * @return: void
    * @Author: 俞先浩
    * @Date: 2021/2/25
    */
    @Override
    public void add(User user) {
        userDao.save(user);
    }
}
