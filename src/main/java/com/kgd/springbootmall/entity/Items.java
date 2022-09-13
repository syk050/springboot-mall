package com.kgd.springbootmall.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "test_item_list")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    private String content;
    private String imgPath;

    @Builder
    public Items(String name, String content, String imgPath) {
        this.name = name;
        this.content = content;
        this.imgPath = imgPath;
    }

    public void update(String name, String content, String imgPath) {
        this.name = name;
        this.content = content;
        this.imgPath = imgPath;
    }
}
