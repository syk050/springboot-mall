package com.kgd.springbootmall.vo;

import com.kgd.springbootmall.dto.ItemTagSaveDto;
import com.kgd.springbootmall.entity.ItemTag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ItemTagListVO {
    private List<ItemTagVO> itemTag;

    public void getList() {
        for (ItemTagVO e : itemTag) {
            System.out.println(e.getItemId() + ": " + e.getTag());
        }

    }
}
