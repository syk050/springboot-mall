package com.kgd.springbootmall.vo;

import com.kgd.springbootmall.entity.ItemTag;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemTagVO {
    private String tag;
    private Long itemId;

    @Builder
    public ItemTagVO(String tag, Long itemId) {
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
