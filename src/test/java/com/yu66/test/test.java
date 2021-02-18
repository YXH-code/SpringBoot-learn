package com.yu66.test;

import com.yu66.dao.UserDao;
import com.yu66.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    private UserDao userDao;

    @Test
//    @Transactional(rollbackFor = Exception.class)
    public void testAdd() {
        userDao.save(new User(3,"gct","123","顾陈涛",20,"2948511003@qq.com"));
        userDao.save(new User(4,"lb","123","刘备",20,"2948511004@qq.com"));
        userDao.save(new User(5,"gy","123","关羽",20,"2948511005@qq.com"));
        userDao.save(new User(6,"zf","123","张飞",20,"2948511006@qq.com"));
    }

}
