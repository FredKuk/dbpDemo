package com.dbp.demo01.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class GJoin {
    int gJoinNo;
    int goodNo;
    int cusNo;
    Date startDate;
    Date changeDate;
    int stat;
}
