package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.request.ApiRequest;
import com.xuexiang.xhttpapi.api.response.ApiResult;
import com.xuexiang.xhttpapi.api.response.LoginInfo;
import com.xuexiang.xhttpapi.component.token.CurrentUser;
import com.xuexiang.xhttpapi.component.token.LoginRequired;
import com.xuexiang.xhttpapi.exception.ApiException;
import com.xuexiang.xhttpapi.model.User;
import com.xuexiang.xhttpapi.service.UserService;
import com.xuexiang.xhttpapi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.xuexiang.xhttpapi.exception.ApiException.ERROR.COMMON_BUSINESS_ERROR;

/**
 * 认证校验
 *
 * @author xuexiang
 * @since 2018/8/6 下午5:56
 */
@RestController
@RequestMapping(value = "/authorization")
public class AuthorizationController {

    @Autowired
    private UserService userService;

    /**
     * 登陆，获取token
     *
     * @param loginUser  登录信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(@RequestBody User loginUser) throws Exception {
        if (userService.findUserByAccount(loginUser.getLoginName()) == null) {
            throw new ApiException("账号不存在！", COMMON_BUSINESS_ERROR);
        }

        User user = userService.login(loginUser.getLoginName(), loginUser.getPassword());

        if (user != null) {
            ApiResult<LoginInfo> apiResult = new ApiResult<>();
            apiResult.setData(new LoginInfo()
                    .setUser(user)
                    .setToken(TokenUtils.createJwtToken(user.getLoginName())));
            return apiResult;
        } else {
            throw new ApiException("用户名或密码错误！", COMMON_BUSINESS_ERROR);
        }
    }

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    public ApiResult getCurrentUser(@CurrentUser User user) throws Exception {
        return new ApiResult<User>().setData(user);
    }



}
