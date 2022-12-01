package com.dbp.demo01.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GReview{
    int gReviewNo;
    int goodNo;
    int cusNo;
    String subject;
    String contents;
    Date startDate;
    Date changeDate;
    int stat;
}
