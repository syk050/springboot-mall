package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.TagResponseDto;
import com.kgd.springbootmall.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TagService {
    private final TagRepository tagRepository;

    /** 태그 가져오기 */
    @Transactional
    public List<TagResponseDto> getTag() {
        return tagRepository.findAll().stream()
                .map(TagResponseDto::new)
                .collect(Collectors.toList());
    }

}
