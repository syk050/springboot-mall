package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.Items;
import lombok.Getter;

@Getter
public class ItemsListResponseDto {
    private Long id;
    private String name;

    public ItemsListResponseDto(Items entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
