package br.com.eatswift.eatswiftbackend.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthResource {

    @GetMapping
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("aplicação no ar");
    }


}
