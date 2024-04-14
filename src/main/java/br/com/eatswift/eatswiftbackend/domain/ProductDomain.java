package br.com.eatswift.eatswiftbackend.domain;


import br.com.eatswift.eatswiftbackend.resources.dto.ProductDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "produtos")
public class ProductDomain {

    @Id
    private String id;

    @Field(name = "nome")
    private String name;


    @Field(name = "preco")
    private Double price;

    @DBRef
    @Field("categoriaId")
    private CategoryDomain category;

    public static ProductDomain fromDto(ProductDto dto, CategoryDomain category){
        return ProductDomain.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .category(category)
                .build();
    }
}
