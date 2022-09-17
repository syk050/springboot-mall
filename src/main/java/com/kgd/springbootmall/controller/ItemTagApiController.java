package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ItemTagResponseDto;
import com.kgd.springbootmall.service.ItemTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemTagApiController {
    private final ItemTagService service;

    @GetMapping("/kgd/tag/{itemId}")
    public ItemTagResponseDto findById(@PathVariable Long itemId) { return service.findById(itemId); }

}
