package com.yu66.service.Impl;

import com.yu66.dao.UserDao;
import com.yu66.entity.User;
import com.yu66.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

/**
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
    public void insertById(User user) {
        userDao.save(user);
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
    * @Description: 根据ID更新用户信息
    * @Param: [id, user_name, password, name]
    * @return: java.util.Optional<com.yu66.entity.User>
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */
    @Override
    public Optional<User> update(User user) {
        Optional<User> newuser = userDao.findById(user.getId());
        newuser.get().setId(user.getId());
        newuser.get().setUser_name(user.getUser_name());
        newuser.get().setPassword(user.getPassword());
        newuser.get().setName(user.getName());
        userDao.save(newuser.get());
        Optional<User> optional = userDao.findById(newuser.get().getId());
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
    * @Description: 根据用户的姓名查询用户
    * @Param: [id]
    * @return: java.lang.String
    * @Author: 俞先浩
    * @Date: 2021/2/9
    */
    @Override
    public List<User> findByName(String name) {
        List<User> user = userDao.findByName(name);
        return user;
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
        List<User> user = userDao.findAll();
        return user;
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
        userDao.save(new User(6,"zf","123","张飞"));
        return "insert user success";
    }

    /**
    * @Description: 根据姓名和密码查询用户
    * @Param: [name, password]
    * @return: com.yu66.entity.User
    * @Author: 俞先浩
    * @Date: 2021/2/10
    */
    @Override
    public List<User> findByNameAndPassword(String name, String password) {
        List<User> user = userDao.findByNameAndPassword(name, password);
        return user;
    }

    /**
    * @Description: 根据姓名或密码查询用户
    * @Param: [name, password]
    * @return: java.util.List<com.yu66.entity.User>
    * @Author: 俞先浩
    * @Date: 2021/2/10
    */
    @Override
    public List<User> findByNameOrPassword(String name, String password) {
        List<User> user = userDao.findByNameOrPassword(name, password);
        return user;
    }

    /**
    * @Description: 根据用户的姓查询用户
    * @Param: [firstname]
    * @return: java.util.List<com.yu66.entity.User>
    * @Author: 俞先浩
    * @Date: 2021/2/10
    */
    @Override
    public List<User> findByNameStartingWith(String firstname) {
        List<User> user = userDao.findByNameStartingWith(firstname);
        return user;
    }

}
