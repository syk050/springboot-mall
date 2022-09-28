package com.kgd.springbootmall.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="test_item_tag")
public class ItemTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tag;

    @Column
    private Long itemId;

    @Builder
    public ItemTag(String tag, Long itemId) {
        this.tag = tag;
        this.itemId = itemId;
    }
}
