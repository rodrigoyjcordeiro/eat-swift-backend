package br.com.eatswift.eatswiftbackend.domain;


import br.com.eatswift.eatswiftbackend.resources.dto.EstablishmentDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "estabelecimentos")
public class EstablishmentDomain {

    @Id
    private String id;
    private String name;

    @DBRef(lazy = true)
    @Builder.Default
    private List<ProductDomain> products = new ArrayList<>();

    @Field("id_categoria")
    private String idCategory;

    public EstablishmentDomain(EstablishmentDto dto, List<ProductDomain> products){
        this.name = dto.getName();
        this.id = dto.getId();
        this.products = products;
        this.idCategory = null;
    }
}
