package com.xuexiang.xhttpapi.mapper;

import com.xuexiang.xhttpapi.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User findUserByAccount(String loginName);

    User login(@Param("loginName") String loginName, @Param("password") String password);
}