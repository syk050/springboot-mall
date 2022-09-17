package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.ItemTagResponseDto;
import com.kgd.springbootmall.entity.ItemTag;
import com.kgd.springbootmall.repository.ItemTagRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ItemTagService {
    private final ItemTagRepository repository;

    /** 아이템 태그 가져오기 */
    @Transactional
    public ItemTagResponseDto findById(Long itemId) {
        ItemTag entity = new ItemTag();
        try {
            entity = repository.findByItemId(itemId);
        }catch (Exception err) {
            System.err.println(err);
        }

        return new ItemTagResponseDto(entity);
    }
}
