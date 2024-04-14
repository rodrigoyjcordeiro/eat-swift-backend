package br.com.eatswift.eatswiftbackend.service;


import br.com.eatswift.eatswiftbackend.domain.EstablishmentDomain;
import br.com.eatswift.eatswiftbackend.domain.ProductDomain;
import br.com.eatswift.eatswiftbackend.repository.EstablishmentRepository;
import br.com.eatswift.eatswiftbackend.repository.ProductRepository;
import br.com.eatswift.eatswiftbackend.resources.dto.EstablishmentDto;
import br.com.eatswift.eatswiftbackend.resources.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;
    private final ProductRepository productRepository;
    public EstablishmentDto save(EstablishmentDto dto){
        List<String> productsIds = dto.getProducts();
        List<ProductDomain> products = productRepository.findAllById(productsIds);
        var domain = new EstablishmentDomain(dto, products);
        EstablishmentDomain establishmentSaved = establishmentRepository.save(domain);

        return null;
    }

    public List<EstablishmentDto> findAll(){
        List<EstablishmentDomain> all = establishmentRepository.findAll();
        return all.stream().map(EstablishmentDto::new).collect(Collectors.toList());
    }

    public List<ProductDto> findProductsByIdEstablishment(String id){
        Optional<EstablishmentDomain> optionalEstablishment = establishmentRepository.findById(id);
        if(optionalEstablishment.isPresent()){
            EstablishmentDomain establishmentDomain = optionalEstablishment.get();
            List<ProductDomain> products = establishmentDomain.getProducts();
            return products.stream().map(ProductDto::fromDomain).collect(Collectors.toList());
        }else {
            return Collections.emptyList();
        }
    }

}
