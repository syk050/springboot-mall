package com.kgd.springbootmall.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsUpdateRequestDto {
    private String name;

    @Builder
    public ItemsUpdateRequestDto(String name) {
        this.name = name;
    }
}
