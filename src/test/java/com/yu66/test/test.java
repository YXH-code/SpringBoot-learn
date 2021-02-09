package com.yu66.test;

import com.yu66.dao.UserDao;
import com.yu66.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    private UserDao userDao;

    @Test
    public void testAdd() {
        User user1 = new User();
        user1.setId(1);
        user1.setUser_name("zs");
        user1.setPassword("123");
        user1.setName("张三");
        userDao.save(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setUser_name("ls");
        user2.setPassword("123");
        user2.setName("李四");
        userDao.save(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setUser_name("ww");
        user3.setPassword("123");
        user3.setName("王五");
        userDao.save(user3);

    }

}
