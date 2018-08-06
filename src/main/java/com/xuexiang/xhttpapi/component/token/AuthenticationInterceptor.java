package com.xuexiang.xhttpapi.component.token;

import com.xuexiang.xhttpapi.config.Constants;
import com.xuexiang.xhttpapi.exception.ApiException;
import com.xuexiang.xhttpapi.model.User;
import com.xuexiang.xhttpapi.service.UserService;
import com.xuexiang.xhttpapi.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

import static com.xuexiang.xhttpapi.exception.ApiException.ERROR.*;

/**
 * 用户认证拦截器
 *
 * @author xuexiang
 * @since 2018/8/6 下午4:40
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    // 在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("----------用户认证拦截器-----------");

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);

        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 判断是否存在令牌信息，如果存在，则允许登录
            String accessToken = request.getHeader("token");

            if (null == accessToken) {
                accessToken = request.getParameter("token");
                if (null == accessToken) {
                    throw new ApiException("无token，请重新登录", TOKEN_MISSING);
                }
            }
            // 从Redis 中查看 token 是否过期
            Claims claims;
            try {
                claims = TokenUtils.parseJWT(accessToken);
            } catch (ExpiredJwtException e) {
                response.setStatus(TOKEN_INVALID);
                throw new ApiException("token失效，请重新登录", TOKEN_INVALID);
            } catch (SignatureException se) {
                response.setStatus(AUTH_ERROR);
                throw new ApiException("token令牌错误", AUTH_ERROR);
            }

            String userName = claims.getId();
            User user = userService.findUserByAccount(userName);

            if (user == null) {
                response.setStatus(TOKEN_INVALID);
                throw new ApiException("用户不存在，请重新登录", TOKEN_INVALID);
            }
            // 当前登录用户@CurrentUser
            request.setAttribute(Constants.CURRENT_USER, user);
            return true;
        } else {//不需要登录可请求
            return true;
        }
    }

    // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
