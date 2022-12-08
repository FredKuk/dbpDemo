package com.dbp.demo01.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

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
@Entity(name="good")
@DynamicInsert
@DynamicUpdate
public class Good{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int goodNo;
    String name;
    int type;
    String company;

    // @CreationTimestamp
	// @Column(name = "startDate")
    LocalDateTime startDate;

    // @Column(name = "changeDate", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
	@Column(name = "changeDate")
    LocalDateTime changeDate;
    int stat;    
}
