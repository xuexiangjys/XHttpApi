package com.xuexiang.xhttpapi.service;

import com.xuexiang.xhttpapi.model.User;

import java.util.List;

/**
 * @author xuexiang
 * @since 2018/7/15 下午10:30
 */
public interface UserService {

    boolean addUser(User user);

    boolean deleteUser(int userId);

    boolean updateUser(User record);

    List<User> findAllUser(int pageNum, int pageSize);

    List<User> findAllUser();
}
