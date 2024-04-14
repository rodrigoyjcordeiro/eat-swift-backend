package br.com.eatswift.eatswiftbackend.resources;

import br.com.eatswift.eatswiftbackend.resources.dto.ProductDto;
import br.com.eatswift.eatswiftbackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto dto){
        ProductDto productDto = this.service.save(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productDto);
    }
}
