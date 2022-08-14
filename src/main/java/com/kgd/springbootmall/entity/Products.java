package com.kgd.springbootmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SpringBootApplication
@EntityListeners(AuditingEntityListener.class)
public class Products {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;
    private String prod_Name; //varchar(80)
    private String prod_category;  //varchar(80)
    private int prod_price;         //int
    private int prod_dc_rate;       // int, 할인률
    private String prod_desc;       // 설명
    private boolean prod_deli;      // 무료배송여부
    private int prod_color;         // 색상여부
    private String prod_seller;     // 판매자
}
