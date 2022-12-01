package com.dbp.demo01.controller;
import java.util.List;
import com.dbp.demo01.model.GComment;

public interface GCommentController {
    public List<GComment> findAll();
    public GComment findById(int gCommentId);
    public GComment create(GComment gComment);
    public GComment update(GComment gComment);
    public GComment delete(int gCommentId);
}
