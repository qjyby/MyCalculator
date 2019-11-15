package com.example.demo.sms.dao;

import com.example.demo.sms.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserInfo, Integer> {
     UserInfo findByPhone(String phone);
}
