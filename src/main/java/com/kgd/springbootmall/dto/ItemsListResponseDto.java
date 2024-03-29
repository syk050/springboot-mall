package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.Items;
import lombok.Getter;

@Getter
public class ItemsListResponseDto {
    private Long id;
    private String name;
    private String content;
    private String imgPath;

    public ItemsListResponseDto(Items entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.content = entity.getContent();
        this.imgPath = entity.getImgPath();
    }
}
