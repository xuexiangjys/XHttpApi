package com.xuexiang.xhttpapi.component.aspect;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 受控的请求
 *
 * @author xuexiang
 * @since 2018/8/7 下午1:59
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
//最高优先级
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface LimitedRequest {

    int DEFAULT_COUNT = 3;

    int DEFAULT_INTERVAL = 30 * 1000;

    /**
     * 允许访问的次数，默认值3
     */
    int count() default DEFAULT_COUNT;

    /**
     *
     * 时间段，单位为毫秒，默认值一分钟
     */
    long interval() default DEFAULT_INTERVAL;

}
