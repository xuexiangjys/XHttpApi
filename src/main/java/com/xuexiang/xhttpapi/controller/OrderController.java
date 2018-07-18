package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.response.ApiResult;
import com.xuexiang.xhttpapi.model.Book;
import com.xuexiang.xhttpapi.model.OrderInfo;
import com.xuexiang.xhttpapi.service.BookService;
import com.xuexiang.xhttpapi.service.OrderService;
import com.xuexiang.xhttpapi.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BookService bookService;

    /**
     * 这里使用的是json直接注入接收，需要注意的是字段名一定要保持一致
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public ApiResult addOrder(@RequestBody OrderInfo order) {
        order.setTime(DateUtils.getNowString(DateUtils.yyyyMMddHHmmss.get()));
        boolean result = orderService.addOrder(order);
        if (result) {
            Book book = bookService.findBookById(order.getBookId());
            book.setSalesVolume(book.getSalesVolume() + order.getNumber());//销量增加
            result = bookService.updateBook(book);
        }
        return new ApiResult<Boolean>().setData(result);
    }

    @ResponseBody
    @RequestMapping(value = "/queryOrder", method = RequestMethod.POST)
    public ApiResult queryOrder(@RequestBody int userId) {
        return new ApiResult<List<OrderInfo>>().setData(orderService.queryOrder(userId));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllOrder/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ApiResult findAllOrder(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return new ApiResult<List<OrderInfo>>().setData(orderService.findAllOrder(pageNum, pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
    public ApiResult findAllOrder() {
        return new ApiResult<List<OrderInfo>>().setData(orderService.findAllOrder());
    }


}
