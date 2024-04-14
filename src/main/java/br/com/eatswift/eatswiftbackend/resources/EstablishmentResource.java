package br.com.eatswift.eatswiftbackend.resources;

import br.com.eatswift.eatswiftbackend.resources.dto.EstablishmentDto;
import br.com.eatswift.eatswiftbackend.resources.dto.ProductDto;
import br.com.eatswift.eatswiftbackend.service.EstablishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estabelecimentos")
@RequiredArgsConstructor
public class EstablishmentResource {
    private final EstablishmentService service;

    @PostMapping
    public ResponseEntity<EstablishmentDto> save(@RequestBody EstablishmentDto dto){
        EstablishmentDto establishmentDto = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(establishmentDto);
    }

    @GetMapping
    public ResponseEntity<List<EstablishmentDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductDto>> findProductsByEstablishmentId(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findProductsByIdEstablishment(id));
    }

    @GetMapping("/{id}/all")
    public ResponseEntity<List<EstablishmentDto>> findByCategoryId(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findEstablishmentByIdCategory(id));
    }

}
