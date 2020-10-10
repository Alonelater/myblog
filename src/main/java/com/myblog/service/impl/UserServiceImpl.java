package com.myblog.service.impl;

import com.myblog.dao.UserMapper;
import com.myblog.pojo.User;

import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper mapper;


    @Override
    public User checkUser(String username, String password) {
        return mapper.checkUser(username,password);
    }
}
