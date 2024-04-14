package br.com.eatswift.eatswiftbackend.resources.dto;


import br.com.eatswift.eatswiftbackend.domain.CategoryDomain;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private String id;
    private String name;
    private String imageUrl;

    public static CategoryDto fromDomain(CategoryDomain domain){
        return CategoryDto.builder()
                .id(domain.getId())
                .name(domain.getName())
                .imageUrl(domain.getImageUrl())
                .build();
    }

}
