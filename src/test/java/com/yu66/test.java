package com.yu66;

import com.yu66.Dao.UserDao;
import com.yu66.Entity.User;
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
        User user = new User();
        user.setId(1);
        user.setUser_name("zs");
        user.setPassword("123");
        user.setName("zhangsan");
        userDao.save(user);

        user = new User();
        user.setId(2);
        user.setUser_name("yxh");
        user.setPassword("666");
        user.setName("俞先浩666");
        userDao.save(user);
    }
}
