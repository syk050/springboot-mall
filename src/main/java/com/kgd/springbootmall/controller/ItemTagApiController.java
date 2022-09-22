package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ItemTagResponseDto;
import com.kgd.springbootmall.dto.ItemTagSaveDto;
import com.kgd.springbootmall.service.ItemTagService;
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
    public Long save(@RequestBody ItemTagSaveDto saveDto) {
        //ToDO https://goateedev.tistory.com/284
        return service.save(saveDto);
    }

}
