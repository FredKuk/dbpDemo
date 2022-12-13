package com.dbp.demo01.service.impl_jaden;

import com.dbp.demo01.model.webflux_jaden.GReview;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GReviewService {

    Flux<GReview> findAll();

    Mono<GReview> findById(Long parseInt);
    
}
