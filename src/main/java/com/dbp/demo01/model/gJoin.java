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
public class GJoin {
    int gJoinNo;
    int goodNo;
    int cusNo;
    Date startDate;
    Date changeDate;
    int stat;
}
