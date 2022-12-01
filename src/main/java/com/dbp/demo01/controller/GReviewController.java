package com.dbp.demo01.controller;
import java.util.List;
import com.dbp.demo01.model.GReview;

public interface GReviewController {
    public List<GReview> findAll();
    public GReview findById(int gReviewId);
    public GReview create(GReview gReview);
    public GReview update(GReview gReview);
    public GReview delete(int gReviewId);
}
