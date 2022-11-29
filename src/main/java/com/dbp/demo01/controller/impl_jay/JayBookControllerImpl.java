package com.dbp.demo01.controller.impl_jay;

import com.dbp.demo01.controller.DbpBookController;
import com.dbp.demo01.model.Book;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class JayBookControllerImpl implements DbpBookController {

    private static ConcurrentHashMap<Integer, Book> bookstore = new ConcurrentHashMap<>();
    private  static  int sequence = 0;

    @Override
    public Book createBook(Book book) {
        book.setBook_id(++sequence);
        bookstore.put(book.getBook_id(), book);
        return book;
    }
    @Override
    public List<Book> findBookAll() {
        return new ArrayList<>(bookstore.values());
    }
}
