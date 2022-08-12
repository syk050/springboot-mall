package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.ItemsListResponseDto;
import com.kgd.springbootmall.dto.ItemsResponseDto;
import com.kgd.springbootmall.dto.ItemsSaveRequestDto;
import com.kgd.springbootmall.dto.ItemsUpdateRequestDto;
import com.kgd.springbootmall.service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private final ItemsService itemsService;

    @PostMapping("/kgd/items")
    public Long save(@RequestBody ItemsSaveRequestDto requestDto) { return itemsService.save(requestDto);}

    @PutMapping("/kgd/items/{id}")
    public Long update(@PathVariable Long id, @RequestBody ItemsUpdateRequestDto requestDto) {
        return itemsService.update(id, requestDto);
    }

    @GetMapping("/kgd/items")
    public List<ItemsListResponseDto> itemsList() {
        return itemsService.getItemsList();
    }

    @GetMapping("/kgd/items/{id}")
    public ItemsResponseDto findById(@PathVariable Long id) { return itemsService.findById(id); }

    @DeleteMapping("/kgd/items/{id}")
    public Long delete(@PathVariable Long id) {
        itemsService.delete(id);
        return id;
    }
}
