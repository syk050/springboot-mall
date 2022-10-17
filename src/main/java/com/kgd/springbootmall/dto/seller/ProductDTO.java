package com.kgd.springbootmall.dto.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private String name;

    private String clarif;

    private String rel_items;

    private Long color_num;                         // 외래키

    private Long deli_num;                          // 외래키

    private Integer cate_num;                       // 외래키


    public ProductDTO(String name, String clarif, String rel_items, Long color_num) {
        this.name = name;
        this.clarif = clarif;
        this.rel_items = rel_items;
        this.color_num = color_num;
    }
}
