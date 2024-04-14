package br.com.eatswift.eatswiftbackend.resources.dto;
import br.com.eatswift.eatswiftbackend.domain.EstablishmentDomain;
import br.com.eatswift.eatswiftbackend.domain.ProductDomain;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentDto {
    private String id;
    private String name;
    private List<String> products = new ArrayList<>();

    public EstablishmentDto(EstablishmentDomain domain){
        this.name = domain.getName();
        this.id = domain.getId();
        this.products = domain.getProducts()
                .stream()
                .map(ProductDomain::getId)
                .collect(Collectors.toList());
    }

}
