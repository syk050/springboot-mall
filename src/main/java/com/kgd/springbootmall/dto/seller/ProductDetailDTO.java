package com.kgd.springbootmall.dto.seller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDTO {

    private String name;

    private String clarif;

    private String rel_items;


    private Long color_num;                         // 외래키

    private String c_name;

    private Integer count;



    private Long deli_num;                          // 외래키



    private Integer cate_num;                       // 외래키


    public ProductDetailDTO(String name, String clarif, String rel_items, Long color_num) {
        this.name = name;
        this.clarif = clarif;
        this.rel_items = rel_items;
        this.color_num = color_num;
    }
}
