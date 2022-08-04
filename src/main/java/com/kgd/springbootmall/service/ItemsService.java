package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.ItemsListResponseDto;
import com.kgd.springbootmall.dto.ItemsResponseDto;
import com.kgd.springbootmall.dto.ItemsSaveRequestDto;
import com.kgd.springbootmall.entity.Items;
import com.kgd.springbootmall.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Transactional
    public Long save(ItemsSaveRequestDto requestDto) {
        return itemsRepository.save(requestDto.toEntity()).getItem_id();
    }

    public ItemsResponseDto findById (Long id) {
        Items entity = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new ItemsResponseDto(entity);
    }

    @Transactional(readOnly = true) // 조회 속도 개선됨
    public List<ItemsListResponseDto> findAllDesc() {
        return itemsRepository.findAllDesc().stream()
                .map(ItemsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }
}
