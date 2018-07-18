package com.xuexiang.xhttpapi.service;

import com.xuexiang.xhttpapi.model.Book;

import java.util.List;

/**
 * 图书服务
 *
 * @author xuexiang
 * @since 2018/7/16 上午9:52
 */
public interface BookService {

    boolean addBook(Book book);

    boolean deleteBook(int bookId);

    boolean updateBook(Book record);

    boolean updatePictureByBookId(Book record);

    Book findBookById(int bookId);

    List<Book> findAllBook(int pageNum, int pageSize);

    List<Book> findAllBook();
}
