package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.response.ApiResult;
import com.xuexiang.xhttpapi.exception.ApiException;
import com.xuexiang.xhttpapi.model.Book;
import com.xuexiang.xhttpapi.service.BookService;
import com.xuexiang.xhttpapi.service.FileStorageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.xuexiang.xhttpapi.exception.ApiException.ERROR.FILE_STORE_ERROR;
import static com.xuexiang.xhttpapi.exception.ApiException.ERROR.UNKNOWN;

/**
 * @author xuexiang
 * @since 2018/7/16 上午11:22
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private FileStorageService fileService;

    /**
     * 测试全局异常捕获返回处理
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ApiResult testError() throws Exception {
        throw new ApiException("测试失败", UNKNOWN);
    }

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
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public ApiResult updateBook(@RequestBody Book book) {
        return new ApiResult<Boolean>().setData(bookService.updateBook(book));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllBook/{pageNum}/{pageSize}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ApiResult findAllBook(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return new ApiResult<List<Book>>().setData(bookService.findAllBook(pageNum, pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/findBooks", method = RequestMethod.POST)
    public ApiResult findBooks(int pageNum, int pageSize) {
        return new ApiResult<List<Book>>().setData(bookService.findAllBook(pageNum, pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllBook", method = RequestMethod.GET)
    public ApiResult findAllBook() {
        return new ApiResult<List<Book>>().setData(bookService.findAllBook());
    }

    @PostMapping("/uploadBookPicture")
    public ApiResult uploadBookPicture(@RequestParam("file") MultipartFile file, @RequestParam("bookId") int bookId) throws Exception {
        ApiResult<Boolean> result = new ApiResult<>();
        try {
            String fileName = fileService.storeFile(file);
            if (!StringUtils.isEmpty(fileName)) {  //更新图片的路径
                Book book = new Book();
                book.setBookId(bookId);
                book.setPicture(fileName);
                result.setData(bookService.updatePictureByBookId(book));
            } else {
                throw new ApiException("图片上传失败", FILE_STORE_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException(e, UNKNOWN);
        }
        return result;
    }

}
