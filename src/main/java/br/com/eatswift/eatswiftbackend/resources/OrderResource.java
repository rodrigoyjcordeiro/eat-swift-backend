package br.com.eatswift.eatswiftbackend.resources;

import br.com.eatswift.eatswiftbackend.resources.dto.OrderDto;
import br.com.eatswift.eatswiftbackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class OrderResource {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrderDto orderDto){
        OrderDto saved = orderService.save(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAllByProps(@RequestParam(value = "establishmentId", required = false) String establishmentId,
                                                         @RequestParam(value = "uid", required = false) String uid){

        if(Objects.nonNull(establishmentId)){
            return ResponseEntity.ok(orderService.findAllByEstablishment(establishmentId));
        }else if (Objects.nonNull(uid)){
            return ResponseEntity.ok(orderService.findAllByUser(uid));
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
    }


}
