package com.dbp.demo01.controller;
import java.util.List;
import com.dbp.demo01.model.Good;

public interface GoodController {
    public List<Good> findAll();
    public Good findById(int goodId);
    public Good create(Good customer);
    public Good update(Good good);
    public Good delete(int goodId);   
}
