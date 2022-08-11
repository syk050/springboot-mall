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

    @PostMapping("/KGD/items")
    public Long save(@RequestBody ItemsSaveRequestDto requestDto) { return itemsService.save(requestDto);}

    @PutMapping("/KGD/items/{id}")
    public Long update(@PathVariable Long id, @RequestBody ItemsUpdateRequestDto requestDto) {
        return itemsService.update(id, requestDto);
    }

    @GetMapping("/KGD/items")
    public List<ItemsListResponseDto> itemsList() {
        return itemsService.getItemsList();
    }

    @GetMapping("/KGD/items/{id}")
    public ItemsResponseDto findById(@PathVariable Long id) { return itemsService.findById(id); }

    @DeleteMapping("/KDG/items/{id}")
    public Long delete(@PathVariable Long id) {
        itemsService.delete(id);
        return id;
    }
}
