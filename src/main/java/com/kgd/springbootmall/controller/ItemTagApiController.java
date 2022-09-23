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

//    @PostMapping("/kgd/item-tag")
//    public Long save(@RequestBody ItemTagSaveDto saveDto) {
//        return service.save(saveDto);
//    }

//    @PostMapping("/kgd/item-tag")
//    public List<Long> saveList(@RequestBody List<ItemTagSaveDto> saveDtoList) {
//        System.out.println("들어옴??");
//        System.out.println(saveDtoList);
//        return service.saveList(saveDtoList);
//    }

    @PostMapping("/kgd/item-tag")
    public List<Long> saveArray(@RequestBody ItemTagSaveDto[] saveDtoArray) {
        System.out.println("들어옴??");
        return service.saveArray(saveDtoArray);
    }

}
