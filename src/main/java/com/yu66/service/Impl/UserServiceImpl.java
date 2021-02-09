package com.yu66.service.Impl;

import com.yu66.dao.UserDao;
import com.yu66.entity.User;
import com.yu66.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @program: springboot-learn
 * @description: 用户业务逻辑层实现类
 * @author: 俞先浩
 * @create: 2021-02-09 11:59
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
    * @Description: 添加用户
    * @Param: [id, user_name, password, name]
    * @return: java.lang.String
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */
    @Override
    public String insertById(int id,String user_name,String password,String name) {
        User user = new User();
        user.setId(id);
        user.setUser_name(user_name);
        user.setPassword(password);
        user.setName(name);
        userDao.save(user);
        return "insert success";
    }

    /**
    * @Description: 根据ID删除用户
    * @Param: [id]
    * @return: java.lang.String
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */
    @Override
    public String deleteById(int id) {
        userDao.deleteById(id);
        return "delete success";
    }

    /**
    * @Description: 更新用户信息
    * @Param: [id, user_name, password, name]
    * @return: java.util.Optional<com.yu66.entity.User>
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */
    @Override
    public Optional<User> update(int id, String user_name, String password, String name) {
        Optional<User> user = userDao.findById(id);
        User newUser = user.get();
        newUser.setId(id);
        newUser.setUser_name(user_name);
        newUser.setPassword(password);
        newUser.setName(name);
        userDao.save(newUser);
        Optional<User> optional = userDao.findById(id);
        return optional;
    }

    /**
    * @Description: 根据ID查询用户
    * @Param: [id]
    * @return: java.util.Optional<com.yu66.entity.User>
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */
    @Override
    public Optional<User> showById(int id) {
        Optional<User> user = userDao.findById(id);
        return user;
    }

    /**
    * @Description: 根据ID查询用户的姓名
    * @Param: [id]
    * @return: java.lang.String
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */
    @Override
    public String showNameById(int id) {
        Optional<User> user = userDao.findById(id);
        User newUser = user.get();
        String name = newUser.getName();
        return name;
    }

    /**
    * @Description:查询所有用户
    * @Param: []
    * @return: java.util.List<com.yu66.entity.User>
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */
    @Override
    public List<User> showAllUser() {
        List<User> users = userDao.findAll();
        return users;
    }

    /**
    * @Description: 插入固定数据测试事务回滚
    * @Param: []
    * @return: java.lang.String
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */

    @Override
    public String insertUser() {
        userDao.save(new User(3,"gct","123","顾陈涛"));
        userDao.save(new User(4,"lb","123","刘备"));
        userDao.save(new User(5,"gy","123","关羽"));
        userDao.save(new User(6,"zf","123","张飞飞123abcLLL哟哟哟"));
        return "insert user success";
    }
}
