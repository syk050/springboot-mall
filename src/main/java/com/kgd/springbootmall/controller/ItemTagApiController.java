package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ItemTagResponseDto;
import com.kgd.springbootmall.dto.ItemTagSaveDto;
import com.kgd.springbootmall.entity.ItemTag;
import com.kgd.springbootmall.service.ItemTagService;
import com.kgd.springbootmall.vo.ItemTagListVO;
import com.kgd.springbootmall.vo.ItemTagVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemTagApiController {
    private final ItemTagService service;

    @GetMapping("/kgd/item-tag")
    public List<ItemTagResponseDto> findAll() { return service.getAllItemsTagList(); }
    @GetMapping("/kgd/item-tag/{itemId}")
    public List<ItemTagResponseDto> findById(@PathVariable Long itemId) { return service.getItemsTagList(itemId); }

//    @PostMapping("/kgd/item-tag")
//    public List<Long> save(@RequestBody ItemTagListVO listVO) {
//        System.out.println("ItemTagListVO");
//        System.out.println("ItemTagListVO");
//
//        listVO.getList();
//
//        return service.saveList(listVO);
//    }

    @PostMapping("/kgd/item-tag")
    public List<Long> save(@RequestBody ItemTagListVO listVO) {
//        List<ItemTagSaveDto>
        System.out.println("ItemTagListVO");

        List<ItemTagVO> list = new ArrayList<>();
        listVO.getItemTag().forEach(e -> {
            ItemTagVO temp = new ItemTagVO(e.getTag(), e.getItemId());
            list.add(temp);
        });
        list.forEach(e -> {
            System.out.println(e.getTag());
            System.out.println(e.getItemId());
        });

        return service.saveList(list);
    }

}
