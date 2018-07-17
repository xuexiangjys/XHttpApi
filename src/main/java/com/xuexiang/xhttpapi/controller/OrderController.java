package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.ApiResult;
import com.xuexiang.xhttpapi.model.Order;
import com.xuexiang.xhttpapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xuexiang
 * @since 2018/7/16 下午2:30
 */
@RestController
@RequestMapping(value = "/order", produces = {"application/json;charset=UTF-8"})
public class OrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 这里使用的是json直接注入接收，需要注意的是字段名一定要保持一致
     * @param order
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public ApiResult addOrder(@RequestBody Order order) {
        return new ApiResult<Boolean>().setData(orderService.addOrder(order));
    }

    @ResponseBody
    @RequestMapping(value = "/queryOrder", method = RequestMethod.POST)
    public ApiResult queryOrder(@RequestBody int userId) {
        return new ApiResult<List<Order>>().setData(orderService.queryOrder(userId));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllOrder/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ApiResult findAllOrder(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return new ApiResult<List<Order>>().setData(orderService.findAllOrder(pageNum, pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
    public ApiResult findAllOrder() {
        return new ApiResult<List<Order>>().setData(orderService.findAllOrder());
    }


}
