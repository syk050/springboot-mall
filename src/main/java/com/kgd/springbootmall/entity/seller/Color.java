package com.kgd.springbootmall.entity.seller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SpringBootApplication
@EntityListeners(AuditingEntityListener.class)
public class Color {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String name;

    private Integer count;


    public Color(String name, Integer count) {
        this.name = name;
        this.count = count;
    }
}
