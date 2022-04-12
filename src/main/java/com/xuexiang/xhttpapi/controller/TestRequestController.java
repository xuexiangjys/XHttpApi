package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.response.ApiResult;
import com.xuexiang.xhttpapi.api.response.CustomApiResult;
import com.xuexiang.xhttpapi.model.Book;
import com.xuexiang.xhttpapi.model.User;
import com.xuexiang.xhttpapi.utils.DateUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 自定义请求测试api
 *
 * @author xuexiang
 * @since 2018/8/7 下午5:57
 */
@RestController
@RequestMapping(value = "/test")
public class TestRequestController {

    @ResponseBody
    @RequestMapping(value = "/testCustomResult", method = RequestMethod.GET)
    public CustomApiResult testCustomResult() throws Exception {
        return new CustomApiResult<Boolean>()
                .setErrorCode(0)
                .setErrorInfo("这是测试的返回信息")
                .setTimeStamp(DateUtils.getNowMills())
                .setResult(true);
    }


    @ResponseBody
    @RequestMapping(value = "/testDataNull", method = RequestMethod.GET)
    public ApiResult testDataNull() throws Exception {
        return new ApiResult<Boolean>()
                .setData(null);
    }

    @ResponseBody
    @RequestMapping(value = "/testCustomApiDataNull", method = RequestMethod.GET)
    public CustomApiResult testCustomApiDataNull() throws Exception {
        return new CustomApiResult<Boolean>()
                .setErrorCode(0)
                .setErrorInfo("请求成功，但是没有数据")
                .setTimeStamp(DateUtils.getNowMills())
                .setResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/testJsonObject")
    public ApiResult testJsonObject(@RequestBody User user) throws Exception {
        return new ApiResult<User>()
                .setData(user);
    }

    @ResponseBody
    @RequestMapping(value = "/testJsonObjectArray")
    public ApiResult testJsonObjectArray(@RequestBody List<User> users) throws Exception {
        return new ApiResult<List<User>>()
                .setData(users);
    }

}
