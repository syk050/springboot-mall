package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.Tag;
import lombok.Getter;

@Getter
public class TagResponseDto {
    private Long id;
    private String tag;

    public TagResponseDto(Tag entity) {
        this.id = entity.getId();
        this.tag = entity.getTag();
    }
}
