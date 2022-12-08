package com.dbp.demo01.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GComment {
    int gCommentNo;
    int gReviewNo;
    String subject;
    String contents;
    Date startDate;
    Date changeDate;
    int stat;
}
