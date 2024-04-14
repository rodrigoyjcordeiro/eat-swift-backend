package br.com.eatswift.eatswiftbackend.domain;

import br.com.eatswift.eatswiftbackend.resources.dto.CategoryDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "categorias")
public class CategoryDomain {

    @Id
    private String id;

    @Field(name = "nome")
    private String name;


    @Field(name = "imagem_url")
    private String imageUrl;

    public CategoryDomain(String name){
        this.name = name;
    }

    public static CategoryDomain fromDto(CategoryDto dto){
        return CategoryDomain.builder().id(dto.getId()).name(dto.getName()).imageUrl(dto.getImageUrl()).build();
    }

}
