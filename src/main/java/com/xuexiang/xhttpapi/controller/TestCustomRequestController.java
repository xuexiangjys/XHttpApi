package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.response.ApiResult;
import com.xuexiang.xhttpapi.api.response.CustomApiResult;
import com.xuexiang.xhttpapi.utils.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义请求测试api
 *
 * @author xuexiang
 * @since 2018/8/7 下午5:57
 */
@RestController
@RequestMapping(value = "/test")
public class TestCustomRequestController {

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

}
