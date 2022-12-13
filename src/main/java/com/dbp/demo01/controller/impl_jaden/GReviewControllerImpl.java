package com.dbp.demo01.controller.impl_jaden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbp.demo01.model.webflux_jaden.GReview;
import com.dbp.demo01.service.impl_jaden.GReviewService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/jaden/greview")
public class GReviewControllerImpl {

    @Autowired
    private GReviewService gReviewService;
    
    @GetMapping("")
    public Flux<GReview> findAll(){
        return gReviewService.findAll();
    }

    @GetMapping("/{gReviewNo}")
    @ResponseBody
    public Mono<GReview> findById(@PathVariable String gReviewNo){
        return gReviewService.findById(Long.parseLong(gReviewNo));
    }

}
