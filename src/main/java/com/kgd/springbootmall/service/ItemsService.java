package com.kgd.springbootmall.service;

import com.kgd.springbootmall.dto.ItemsListResponseDto;
import com.kgd.springbootmall.dto.ItemsResponseDto;
import com.kgd.springbootmall.dto.ItemsSaveRequestDto;
import com.kgd.springbootmall.dto.ItemsUpdateRequestDto;
import com.kgd.springbootmall.entity.Items;
import com.kgd.springbootmall.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    /** 아이템 목록 가져오기 */
    @Transactional
    public List<ItemsListResponseDto> getItemsList() {
        return itemsRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(ItemsListResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    /** 아이템 가져오기 */
    @Transactional
    public ItemsResponseDto findById(Long id) {
        Items entity = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

        return new ItemsResponseDto(entity);
    }

    /** 아이템 등록 */
    @Transactional
    public Long save(ItemsSaveRequestDto requestDto) {
        return itemsRepository.save(requestDto.toEntity()).getId();
    }

    /** 아이템 수정 */
    @Transactional
    public Long update(Long id, ItemsUpdateRequestDto requestDto) {
        Items items = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

        items.update(requestDto.getName(), requestDto.getContent(), requestDto.getImgPath());

        return id;
    }

    /** 아이템 삭제 */
    @Transactional
    public void delete(Long id) {
        Items items = itemsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

        // JpaRepository에서 delete 메소드를 지원
        // 엔티티를 파라미터로 삭제 or deleteById를 이용하여 id로 삭제
        // 존재하는 Posts인지 엔티티 조회 후 그대로 삭제
        itemsRepository.delete(items);
    }


}
