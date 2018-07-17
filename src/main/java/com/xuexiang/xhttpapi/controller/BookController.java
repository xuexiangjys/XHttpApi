package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.ApiResult;
import com.xuexiang.xhttpapi.model.Book;
import com.xuexiang.xhttpapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xuexiang
 * @since 2018/7/16 上午11:22
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 这里使用的是json直接注入接收，需要注意的是字段名一定要保持一致
     * @param book
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ApiResult addBook(@RequestBody Book book) {
        return new ApiResult<Boolean>().setData(bookService.addBook(book));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllBook/{pageNum}/{pageSize}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ApiResult findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return new ApiResult<List<Book>>().setData(bookService.findAllBook(pageNum, pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllBook", method = RequestMethod.GET)
    public ApiResult findAllUser() {
        return new ApiResult<List<Book>>().setData(bookService.findAllBook());
    }
}
