package br.com.eatswift.eatswiftbackend.service;

import br.com.eatswift.eatswiftbackend.domain.CategoryDomain;
import br.com.eatswift.eatswiftbackend.domain.ProductDomain;
import br.com.eatswift.eatswiftbackend.repository.CategoryRepository;
import br.com.eatswift.eatswiftbackend.repository.ProductRepository;
import br.com.eatswift.eatswiftbackend.resources.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductDto save(ProductDto dto){
        CategoryDomain categoryDomain = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        ProductDomain ProductDomain = br.com.eatswift.eatswiftbackend.domain.ProductDomain.fromDto(dto, categoryDomain);
        ProductDomain domain = this.productRepository.save(ProductDomain);
        return ProductDto.fromDomain(domain);
    }   

    public List<ProductDto> findAll(){
        List<ProductDomain> categories = this.productRepository.findAll();
        return categories.stream().map(ProductDto::fromDomain).collect(Collectors.toList());
    }

}
