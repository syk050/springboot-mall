package com.kgd.springbootmall.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity(name="test_item_tag")
public class ItemTag {
    @Id
    private Long id;

    @Column
    private String tag;

    @Column
    private Long itemId;
}
