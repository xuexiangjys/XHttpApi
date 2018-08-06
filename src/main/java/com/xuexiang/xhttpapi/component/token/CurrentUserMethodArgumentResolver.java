package com.xuexiang.xhttpapi.component.token;

import com.xuexiang.xhttpapi.config.Constants;
import com.xuexiang.xhttpapi.model.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 *
 * 自定义参数解析器
 * @author xuexiang
 * @since 2018/8/6 下午5:09
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println("----------supportsParameter-----------" + parameter.getParameterType());
        return parameter.getParameterType().isAssignableFrom(User.class)//判断是否能转成User类型
                && parameter.hasParameterAnnotation(CurrentUser.class);//是否有CurrentUser注解
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        System.out.println("--------------resolveArgument-------------" + parameter);
        User user = (User) nativeWebRequest.getAttribute(Constants.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
        if (user != null) {
            return user;
        }
        throw new MissingServletRequestPartException(Constants.CURRENT_USER);
    }
}
