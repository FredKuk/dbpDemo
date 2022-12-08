package com.dbp.demo01.controller;
import java.util.List;
import com.dbp.demo01.model.GJoin;

public interface GJoinController {
    public List<GJoin> findAll();
    public GJoin findById(int gJoinNo);
    public GJoin create(GJoin gJoinNo);
    public GJoin update(GJoin gJoinNo);
    public GJoin delete(int gJoinNo);
}
