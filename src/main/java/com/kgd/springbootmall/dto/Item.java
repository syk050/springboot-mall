package com.kgd.springbootmall.dto;

// DTO의 getter/setter/generator 생성 단축키 : alt + insert   !!!!!!!!!!!!!
public class Item {
    private String id;
    private String title;

    public Item(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
