package com.dbp.demo01.service;

import java.util.List;

import com.dbp.demo01.model.Book;

public interface BookService {
    public List<Book> findAll();
    public Book create(int book_id);
}
