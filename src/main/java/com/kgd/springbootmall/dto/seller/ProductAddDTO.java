package com.kgd.springbootmall.dto.seller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddDTO {

    private String name;
    private String rel_items;

    private String category;

    private String clarif;

    private String c_name;

    private Integer count;


}

