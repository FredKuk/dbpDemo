package com.dbp.demo01.controller.impl_jaden;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbp.demo01.controller.DbpBookController;
import com.dbp.demo01.model.Book;
import com.dbp.demo01.service.BookService;

@RestController
public class DbpBookControllerImpl implements DbpBookController{

    @Qualifier("ComicBookServiceImpl")
    BookService booksService;
    
    @Override
    @GetMapping("/jaden/book")
    public List<Book> findBookAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @PostMapping("/jaden/book")
    public Book createBook(@RequestBody Book book) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
