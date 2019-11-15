package com.example.demo.sms.dao;

import com.example.demo.sms.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void findByUsername() {
    }

    @Test
    public void save() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword("admin");
        userInfo.setPhone("15505916860");
        userDao.save(userInfo);
    }
}