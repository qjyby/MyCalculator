package com.example.demo.sms.service.impl;

import com.example.demo.sms.dao.UserDao;
import com.example.demo.sms.entity.UserInfo;
import com.example.demo.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfo findOne(String phone) {
        return userDao.findByPhone(phone);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userDao.save(userInfo);
    }
}
