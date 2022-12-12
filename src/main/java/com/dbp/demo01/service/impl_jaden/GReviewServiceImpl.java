package com.dbp.demo01.service.impl_jaden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbp.demo01.model.webflux_jaden.GReview;
import com.dbp.demo01.repository.webflux_jaden.GReviewRepository;

import reactor.core.publisher.Flux;

@Service
public class GReviewServiceImpl implements GReviewService{

    @Autowired
    private GReviewRepository gReviewRepository;
    
    @Override
    public Flux<GReview> findAll() {
        return gReviewRepository.findAll();
    }
    
}
