package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.ItemTag;
import lombok.Getter;

@Getter
public class ItemTagResponseDto {
    private Long id;
    private String tag;
    private Long itemId;

    public ItemTagResponseDto(ItemTag entity) {
        this.id = entity.getId();
        this.tag = entity.getTag();
        this.itemId = entity.getItemId();
    }
}
