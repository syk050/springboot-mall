package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.dto.TagResponseDto;
import com.kgd.springbootmall.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TagApiController {
    private  final TagService tagService;

    @GetMapping("/kgd/tag")
    public List<TagResponseDto> getTag() {
        return tagService.getTag();
    }
}
