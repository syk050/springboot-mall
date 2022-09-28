package com.kgd.springbootmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

    private String color;         // int, 색상여부

    private String seller;     // varchar2(30), 판매자

    private String rel_items;   // 관련 아이템(아이템 선택 시, 구매할 수 있는 옵션 상품)

    private String img_url;


    public Products(String name, String category, int price, int dc_rate, String clarif, boolean deli, String color, String seller, String rel_items) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.dc_rate = dc_rate;
        this.clarif = clarif;
        this.deli = deli;
        this.color = color;
        this.seller = seller;
        this.rel_items = rel_items;
    }
}
