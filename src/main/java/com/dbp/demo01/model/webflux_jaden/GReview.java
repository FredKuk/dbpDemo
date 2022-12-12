package com.dbp.demo01.model.webflux_jaden;

import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "gReview")
public class GReview{
    @Id
    Long gReviewNo;
    int goodNo;
    int cusNo;
    String subject;
    String contents;
    LocalDateTime startDate;
    LocalDateTime changeDate;
    int stat;
}