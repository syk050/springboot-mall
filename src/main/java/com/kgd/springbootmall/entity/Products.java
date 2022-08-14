package com.kgd.springbootmall.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@SpringBootApplication
@EntityListeners(AuditingEntityListener.class)
public class Products {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;       // varchar2(80), 제품명

    private String category;   // varchar2(80), 소속 카테고리

    private int price;         // int, 가격

    private int dc_rate;       // int, 할인률

    private String clarif;       // varchar2(200), 설명

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean deli;      // Boolean, 무료배송여부

    private int color;         // int, 색상여부

    private String seller;     // varchar2(30), 판매자


    public Products(String name, String category, int price, int dc_rate, String clarif, boolean deli, int color, String seller) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.dc_rate = dc_rate;
        this.clarif = clarif;
        this.deli = deli;
        this.color = color;
        this.seller = seller;
    }
}
