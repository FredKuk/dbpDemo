package com.dbp.demo01.controller.impl_jaden;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbp.demo01.model.extd.ComicBook;
import com.dbp.demo01.service.impl_jaden.ComicBookService;

@RestController
@RequestMapping("/jaden")
public class ComicBookControllerImpl implements ComicBookController{

    @Autowired
    private ComicBookService comicBookService;

    @Override
    @GetMapping("/book")
    public List<ComicBook> findComicBookAll() {
        return comicBookService.findAll();
    }    
}
