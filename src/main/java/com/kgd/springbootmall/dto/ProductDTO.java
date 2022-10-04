package com.kgd.springbootmall.dto;


import com.kgd.springbootmall.entity.seller.Products;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    @NotNull
    private int id;

    private String name;       // varchar2(80), 제품명

    private String category;   // varchar2(80), 소속 카테고리

    private int price;         // int, 가격

    private int dc_rate;       // int, 할인률

    private String clarif;       // varchar2(200), 설명

    private boolean deli;      // Boolean, 무료배송여부

    private String color;         // int, 색상여부

    private String seller;     // varchar2(30), 판매자

    private String rel_items;   // varchar2(30), 관련 아이템

    @Builder
    public ProductDTO(int id, String name, String category, int price, int dc_rate, String clarif, boolean deli, String color, String seller, String rel_items) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.dc_rate = dc_rate;
        this.clarif = clarif;
        this.deli = deli;
        this.color = color;
        this.seller = seller;
        this.rel_items = rel_items;
    }

    @Builder
    public ProductDTO(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductDTO toDTO(Products p){
        ProductDTO dto = ProductDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .category(p.getCategory())
                .price(p.getPrice())
                .dc_rate(p.getDc_rate())
                .clarif(p.getClarif())
                .deli(p.isDeli())
                .color(p.getColor())
                .seller(p.getSeller())
                .rel_items(p.getRel_items())
                .build();
        return dto;
    }

    public ProductDTO toSubDTO(Products p){
        ProductDTO dto = ProductDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .price(p.getPrice())
                .build();
        return dto;
    }

    public Page<ProductDTO> toDTOPage(Page<Products> pList){
        Page<ProductDTO> dtoList = pList.map(p -> ProductDTO.builder()
                .id(getId())
                .name(p.getName())
                .category(p.getCategory())
                .price(p.getPrice())
                .dc_rate(p.getDc_rate())
                .clarif(p.getClarif())
                .deli(p.isDeli())
                .color(p.getColor())
                .seller(p.getSeller())
                .rel_items(p.getRel_items())
                .build());

        return dtoList;
    }


    // 생성자로도 충분히 DTO를 만들 수 있지만, Builder 패턴을 사용할 경우, 생성자보다 DTO 생성코드가 간단해지고, 생성자와 달리 메서드명으로 호출할 수 있다.



}
