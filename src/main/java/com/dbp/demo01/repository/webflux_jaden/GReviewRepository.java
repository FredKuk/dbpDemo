package com.dbp.demo01.repository.webflux_jaden;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.dbp.demo01.model.webflux_jaden.GReview;

public interface GReviewRepository extends R2dbcRepository<GReview, Long> {
    
}
