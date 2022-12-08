package com.dbp.demo01.model;

import java.time.LocalDateTime;

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
public class Customer {
    int cusNo;
    String name;
    String id;
    String pwd;
    LocalDateTime startDate;
    LocalDateTime changeDate;
    int stat;
}
