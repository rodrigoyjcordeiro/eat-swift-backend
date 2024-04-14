package br.com.eatswift.eatswiftbackend.service;

import br.com.eatswift.eatswiftbackend.domain.CategoryDomain;
import br.com.eatswift.eatswiftbackend.repository.CategoryRepository;
import br.com.eatswift.eatswiftbackend.resources.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto save(CategoryDto dto){
        CategoryDomain categoryDomain = CategoryDomain.fromDto(dto);
        CategoryDomain domain = this.categoryRepository.save(categoryDomain);
        return CategoryDto.fromDomain(domain);
    }

    public List<CategoryDto> findAll(){
        List<CategoryDomain> categories = this.categoryRepository.findAll();
        return categories.stream().map(CategoryDto::fromDomain).collect(Collectors.toList());
    }

}
