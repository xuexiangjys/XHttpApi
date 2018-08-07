package com.xuexiang.xhttpapi.utils;

import com.xuexiang.xhttpapi.component.aspect.LimitedRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 快速请求工具类
 *
 * @author xuexiang
 * @since 2018/8/7 下午2:27
 */
public class QuickRequestUtils {

    private QuickRequestUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }


    private static Map<String, Integer> redisTemplate = new HashMap<>();

    /**
     * 是否是快速请求
     *
     * @param key
     * @param limit
     * @return
     */
    public static boolean isQuickRequest(String key, LimitedRequest limit) {
        int count = redisTemplate.getOrDefault(key, 0) + 1;
        redisTemplate.put(key, count);

        if (count > 0) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() { //创建一个新的计时器任务。
                @Override
                public void run() {
                    int number = redisTemplate.getOrDefault(key, 0) - 1;
                    if (number > 0) {
                        redisTemplate.put(key, number);
                    } else {
                        redisTemplate.remove(key);
                    }
                }
            };
            timer.schedule(task, limit.interval());  //安排在指定延迟后执行指定的任务。task : 所要安排的任务。: 执行任务前的延迟时间，单位是毫秒。
        }
        return count > limit.count();
    }


}
