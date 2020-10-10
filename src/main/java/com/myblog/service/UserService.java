package com.myblog.service;

import com.myblog.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User checkUser(String username,String password);
}
