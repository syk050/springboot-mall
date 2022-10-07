package com.kgd.springbootmall.entity.seller;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@SpringBootApplication
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String name;

    private String clarif;

    private String rel_items;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate regdate;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate rendate;

    private Long color_num;                         // 외래키

    private Long deli_num;                          // 외래키

    private Integer cate_num;                       // 외래키



}
