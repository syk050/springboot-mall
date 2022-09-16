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
@Entity(name = "test_tag")
public class Tag {
    @Id
    private Long id;

    @Column
    private String tag;

    @Builder
    public Tag(String tag) {
        this.tag = tag;
    }
}
