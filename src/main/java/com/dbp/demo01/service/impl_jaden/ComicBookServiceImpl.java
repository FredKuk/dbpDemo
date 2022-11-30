package com.dbp.demo01.service.impl_jaden;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbp.demo01.model.extd.ComicBook;
import com.dbp.demo01.repository.impl_jaden.ComicBookRepository;

@Service
public class ComicBookServiceImpl implements ComicBookService{

    @Autowired
    ComicBookRepository comicBookRepository;

    @Override
    public List<ComicBook> findAll() {
        return comicBookRepository.findAll();
    }
    
}
