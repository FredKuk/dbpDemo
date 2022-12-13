package com.dbp.demo01.model.webflux_jaden;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
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
    @Column("gReviewNo")
    Long gReviewNo;

    @Column("goodNo")
    int goodNo;

    @Column("cusNo")
    int cusNo;

    String subject;

    String contents;

    @Column("startDate")
    LocalDateTime startDate;

    @Column("changeDate")
    LocalDateTime changeDate;

    int stat;
    
}