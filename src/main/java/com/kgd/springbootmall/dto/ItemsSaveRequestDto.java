package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.Items;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsSaveRequestDto {

    private String itemName;

    @Builder
    public ItemsSaveRequestDto(String itemName) {
        this.itemName = itemName;
    }

    public Items toEntity() {
        return Items.builder()
                .item_name(itemName)
                .build();
    }
}
