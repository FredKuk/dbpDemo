package com.dbp.demo01.controller.impl_jay;

import com.dbp.demo01.controller.DbpBookController;
import com.dbp.demo01.model.Book;
import com.dbp.demo01.model.extd.JayBook;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class JayBookControllerImpl implements DbpBookController {

    @Override
    public List<Book> findBookAll() {
        return null;
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }
}
