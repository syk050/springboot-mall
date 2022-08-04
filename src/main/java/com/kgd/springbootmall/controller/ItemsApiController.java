package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ItemsResponseDto;
import com.kgd.springbootmall.dto.ItemsSaveRequestDto;
import com.kgd.springbootmall.service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private final ItemsService itemsService;

    @PostMapping("/KGD/items")
    public Long save(@RequestBody ItemsSaveRequestDto requestDto) { return itemsService.save(requestDto);}

    @GetMapping("/KGD/items/{id}")
    public ItemsResponseDto findById(@PathVariable Long id) { return itemsService.findById(id); }
}
