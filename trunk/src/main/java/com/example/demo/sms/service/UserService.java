package com.example.demo.sms.service;

import com.example.demo.sms.entity.UserInfo;

public interface UserService {

    UserInfo findOne(String username);

    UserInfo  save(UserInfo userInfo);
}
