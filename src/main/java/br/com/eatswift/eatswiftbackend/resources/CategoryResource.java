package br.com.eatswift.eatswiftbackend.resources;

import br.com.eatswift.eatswiftbackend.resources.dto.CategoryDto;
import br.com.eatswift.eatswiftbackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoryResource {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto dto){
        CategoryDto categoryDto = this.service.save(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryDto);
    }
}
