package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.ApiResult;
import com.xuexiang.xhttpapi.model.User;
import com.xuexiang.xhttpapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 控制器
 *
 * @author xuexiang
 * @since 2018/7/15 下午11:23
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public ApiResult addUser(User user){
        ApiResult<Boolean> result = new ApiResult<>();
        return result.setData(userService.addUser(user));
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public ApiResult findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        ApiResult<List<User>> result = new ApiResult<>();
        return result.setData(userService.findAllUser(pageNum,pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/all")
    public ApiResult findAllUser() {
        ApiResult<List<User>> result = new ApiResult<>();
        return result.setData(userService.findAllUser());
    }
}
