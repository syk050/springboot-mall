package com.kgd.springbootmall.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsUpdateRequestDto {
    private String name;
    private String content;
    private String imgPath;

    @Builder
    public ItemsUpdateRequestDto(String name, String content, String imgPath) {
        this.name = name;
        this.content = content;
        this.imgPath = imgPath;
    }
}
