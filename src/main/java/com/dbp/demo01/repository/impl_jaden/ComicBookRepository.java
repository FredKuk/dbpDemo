package com.dbp.demo01.repository.impl_jaden;

import java.util.List;

import com.dbp.demo01.model.extd.ComicBook;


public interface ComicBookRepository {
    public List<ComicBook> findAll();
}
