package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.ItemTagResponseDto;
import com.kgd.springbootmall.dto.ItemTagSaveDto;
import com.kgd.springbootmall.entity.ItemTag;
import com.kgd.springbootmall.repository.ItemTagRepository;
import com.kgd.springbootmall.vo.ItemTagListVO;
import com.kgd.springbootmall.vo.ItemTagVO;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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

    /** 아이템 태그 리스트 등록 */
//    @Transactional
//    public List<Long> saveList(List<ItemTagSaveDto> saveDtoList) {
//        return repository.saveAll(saveDtoList.stream()
//                .map(ItemTagSaveDto::toEntity)
//                .collect(Collectors.toList())).stream()
//                .map(ItemTag::getItemId)
//                .collect(Collectors.toList());
//    }

//    @Transactional
//    public List<Long> saveList(ItemTagListVO tagListVO) {
//        return repository.saveAll(tagListVO.getItemTag().stream()
//                .map(ItemTagSaveDto::toEntity)
//                .collect(Collectors.toList())).stream()
//                .map(ItemTag::getItemId)
//                .collect(Collectors.toList());
//    }

    @Transactional
    public List<Long> saveList(List<ItemTagVO> list) {
        List<Long> idList = new ArrayList<>();
        list.forEach(e -> {
            idList.add(repository.save(e.toEntity()).getItemId());
        });

        return idList;
    }

    /** 아이템 태그 배열 등록 */
    @Transactional
    public List<Long> saveArray(ItemTagSaveDto[] saveDtoArray) {
        List<ItemTagSaveDto> saveDtoList = Arrays.asList(saveDtoArray);
        return repository.saveAll(saveDtoList.stream()
                .map(ItemTagSaveDto::toEntity)
                .collect(Collectors.toList())).stream()
                .map(ItemTag::getItemId)
                .collect(Collectors.toList());
    }

}
