package com.dbp.demo01.controller;
import java.util.List;
import com.dbp.demo01.model.GJoin;

public interface GJoinController {
    public List<GJoin> findAll();
    public GJoin findById(int gJoinId);
    public GJoin create(GJoin gJoin);
    public GJoin update(GJoin gJoin);
    public GJoin delete(int gJoinId);
}
