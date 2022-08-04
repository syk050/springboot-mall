package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.Items;
import lombok.Getter;

@Getter
public class ItemsListResponseDto {
    private Long item_id;
    private String item_name;

    public ItemsListResponseDto(Items entity) {
        this.item_id = entity.getItem_id();
        this.item_name = entity.getItem_name();
    }
}
