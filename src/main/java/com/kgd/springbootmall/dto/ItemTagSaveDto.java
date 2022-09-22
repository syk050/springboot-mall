package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.ItemTag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemTagSaveDto {
    private String tag;
    private Long itemId;

    @Builder
    public ItemTagSaveDto(String tag, Long itemId) {
        this.tag = tag;
        this.itemId = itemId;
    }

    public ItemTag toEntity() {
        return ItemTag.builder()
                .tag(tag)
                .itemId(itemId)
                .build();
    }
}
