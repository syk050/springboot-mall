package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.Items;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsSaveRequestDto {

    private String name;

    @Builder
    public ItemsSaveRequestDto(String name) {
        this.name = name;
    }

    public Items toEntity() {
        return Items.builder()
                .name(name)
                .build();
    }
}
