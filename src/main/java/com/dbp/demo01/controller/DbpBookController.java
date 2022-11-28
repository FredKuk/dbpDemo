package com.dbp.demo01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.dbp.demo01.model.Book;

public interface DbpBookController {
    public List<Book> findBookAll();
    public Book createBook(@RequestBody Book book);
}
