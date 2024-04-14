package br.com.eatswift.eatswiftbackend.resources.dto;


import br.com.eatswift.eatswiftbackend.domain.CategoryDomain;
import br.com.eatswift.eatswiftbackend.domain.ProductDomain;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private Double price;
    private String categoryId;

    public static ProductDto fromDomain(ProductDomain domain){
        return ProductDto.builder()
                .id(domain.getId())
                .name(domain.getName())
                .price(domain.getPrice())
                .build();
    }

}
