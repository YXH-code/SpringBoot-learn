package com.yu66.controller;

import com.yu66.entity.Book;
import com.yu66.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @description: 图书馆页面控制器
 * @author: 俞先浩
 * @create: 2021-02-24 16:24
 **/
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return bookService.list();
        } else {
            return bookService.Search(keywords);
        }
    }
}
