package com.kgd.springbootmall.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="test_item_tag")
public class ItemTag {
    @Id
    private Long id;

    @Column
    private String tag;

    @Column
    private Long itemId;

    @Builder
    public ItemTag(Long id, String tag, Long itemId) {
        this.id = id;
        this.tag = tag;
        this.itemId = itemId;
    }
}
