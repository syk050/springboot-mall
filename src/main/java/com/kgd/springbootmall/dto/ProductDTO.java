package com.kgd.springbootmall.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

    @NotNull
    private int id;

    private String name;       // varchar2(80), 제품명

    private String category;   // varchar2(80), 소속 카테고리

    private int price;         // int, 가격

    private int dc_rate;       // int, 할인률

    private String clarif;       // varchar2(200), 설명

    private boolean deli;      // Boolean, 무료배송여부

    private String color;         // int, 색상여부

    private String seller;     // varchar2(30), 판매자
    
    private String rel_items;   // varchar2(30), 관련 아이템


    public ProductDTO(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
