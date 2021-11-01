package ro.exercise.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ro.exercise.reactive.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends ReactiveCrudRepository<ShoppingCart, Long> {
    void save(Mono<ShoppingCart> shoppingCartMono);
}
