package com.xuexiang.xhttpapi.service;

import com.xuexiang.xhttpapi.model.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author xuexiang
 * @since 2018/7/15 下午10:30
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    boolean deleteUser(int userId);

    /**
     * 更新用户
     *
     * @param record
     * @return
     */
    boolean updateUser(User record);

    /**
     * 分页查询所有用户信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> findAllUser(int pageNum, int pageSize);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据账户名找到用户信息
     * @param loginName
     * @return
     */
    User findUserByAccount(String loginName);

    /**
     * 用户登陆
     * @param loginName
     * @param password
     * @return
     */
    User login(String loginName, String password);
}
