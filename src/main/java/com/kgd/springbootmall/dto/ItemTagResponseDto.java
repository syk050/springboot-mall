package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.ItemTag;
import lombok.Getter;

@Getter
public class ItemTagResponseDto {
    private String tag;

    public ItemTagResponseDto(ItemTag entity) {
        this.tag = entity.getTag();
    }
}
