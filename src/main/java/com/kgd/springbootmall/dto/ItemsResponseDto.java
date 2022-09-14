package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.Items;
import lombok.Getter;

@Getter
public class ItemsResponseDto {

    private Long id;
    private String name;
    private String content;
    private String imgPath;

    public ItemsResponseDto(Items entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.content = entity.getContent();
        this.imgPath = entity.getImgPath();
    }
}
