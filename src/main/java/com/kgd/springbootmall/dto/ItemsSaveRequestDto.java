package com.kgd.springbootmall.dto;

import com.kgd.springbootmall.entity.Items;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemsSaveRequestDto {

    private String name;
    private String content;
    private String imgPath;

    @Builder
    public ItemsSaveRequestDto(String name, String content, String imgPath) {
        this.name = name;
        this.content = content;
        this.imgPath = imgPath;
    }

    public Items toEntity() {
        return Items.builder()
                .name(name)
                .content(content)
                .imgPath(imgPath)
                .build();
    }
}
