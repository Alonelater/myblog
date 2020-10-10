package com.myblog.dao;

import com.myblog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User checkUser(@Param("username") String username, @Param("password") String password);

}
