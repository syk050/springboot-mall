package com.kgd.springbootmall.dto.seller;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class ColorDTO {

    private String name;

    private Integer count;

    public ColorDTO(String name, Integer count) {
        this.name = name;
        this.count = count;
    }
}