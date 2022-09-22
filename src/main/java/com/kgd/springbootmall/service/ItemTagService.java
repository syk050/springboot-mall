package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.ItemTagResponseDto;
import com.kgd.springbootmall.dto.ItemTagSaveDto;
import com.kgd.springbootmall.dto.ItemsListResponseDto;
import com.kgd.springbootmall.dto.ProductDTO;
import com.kgd.springbootmall.entity.ItemTag;
import com.kgd.springbootmall.repository.ItemTagRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ItemTagService {
    private final ItemTagRepository repository;

    /** 아이템 태그 전부 가져오기 */
    @Transactional
    public List<ItemTagResponseDto> getAllItemsTagList() {

        return repository.findAll().stream()
                .map(ItemTagResponseDto::new)
                .collect(Collectors.toList());
    }

    /** 해당 아이템 태그 가져오기 */
    @Transactional
    public List<ItemTagResponseDto> getItemsTagList(Long itemId) {

        return repository.findByItemId(itemId).stream()
                .map(ItemTagResponseDto::new)
                .collect(Collectors.toList());
    }

    /** 아이템 태그 등록 */
    @Transactional
    public Long save(ItemTagSaveDto saveDto) { return repository.save(saveDto.toEntity()).getItemId();}
}
