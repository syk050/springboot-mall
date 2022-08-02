package com.kgd.springbootmall.controller;

import com.kgd.springbootmall.service.ItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemsApiController {

    private ItemsService itemsService;
}
