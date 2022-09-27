package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ItemTagResponseDto;
import com.kgd.springbootmall.service.ItemTagService;
import com.kgd.springbootmall.vo.ItemTagListVO;
import com.kgd.springbootmall.vo.StringListVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemTagApiController {
    private final ItemTagService service;

    @GetMapping("/kgd/item-tag")
    public List<ItemTagResponseDto> findAll() { return service.getAllItemsTagList(); }
    @GetMapping("/kgd/item-tag/{itemId}")
    public List<ItemTagResponseDto> findById(@PathVariable Long itemId) { return service.getItemsTagList(itemId); }

    @PostMapping("/kgd/item-tag")
    public void save(@RequestBody ItemTagListVO listVO) {
        System.out.println("ItemTagListVO");
        listVO.getList();
    }

}
