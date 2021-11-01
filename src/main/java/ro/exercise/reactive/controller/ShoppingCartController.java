package ro.exercise.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ro.exercise.reactive.entity.ShoppingCart;
import ro.exercise.reactive.repository.ShoppingCartRepository;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @GetMapping("/carts")
    public Flux<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @PostMapping("/carts")
    public Mono<ResponseEntity> createShoppingCart(@RequestBody Mono<ShoppingCart> cartMono) {
        return cartMono
                .flatMap(e -> shoppingCartRepository.save(e))
                .map(ResponseEntity::ok);

    }
}
