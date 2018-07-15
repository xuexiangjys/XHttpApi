package com.xuexiang.xhttpapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.xuexiang.xhttpapi.mapper.UserMapper;
import com.xuexiang.xhttpapi.model.User;
import com.xuexiang.xhttpapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuexiang
 * @since 2018/7/15 下午11:13
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public boolean addUser(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean deleteUser(int userId) {
        return userMapper.deleteByPrimaryKey(userId) > 0;
    }

    @Override
    public boolean updateUser(User record) {
        return userMapper.updateByPrimaryKey(record) > 0;
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAll();
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.selectAll();
    }
}
