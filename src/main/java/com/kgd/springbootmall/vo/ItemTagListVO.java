package com.kgd.springbootmall.vo;

import lombok.Getter;

import java.util.List;

@Getter
public class ItemTagListVO {
    private List<ItemTagVO> itemTag;

    public void getList() {
        for (ItemTagVO e : itemTag) {
            System.out.println(e.getItemId() + ": " + e.getTag());
        }

    }
}
