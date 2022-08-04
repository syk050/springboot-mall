package com.kgd.springbootmall.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@NoArgsConstructor
@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @Column(length = 50, nullable = false)
    private String item_name;

    @Builder
    public Items(String item_name) {
        this.item_name = item_name;
    }

    public void update(String item_name) {
        this.item_name = item_name;
    }
}
