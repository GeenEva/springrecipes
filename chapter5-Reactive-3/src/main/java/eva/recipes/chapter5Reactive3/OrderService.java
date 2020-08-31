package eva.recipes.chapter5Reactive3;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

    private final Map<String, Order> orders = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        OrderGenerator generator = new OrderGenerator();
        for (int i = 0 ; i<25 ; i++){
            Order order = generator.generate();
            orders.put(order.getId(), order);
        }
    }

    public Mono<Order> findById(String id){
        return Mono.justOrEmpty(orders.get(id));
    }

    public Mono<Order> save(Mono<Order> order){
        return order.map(this::sayve);
    }

    private Order sayve(Order order){
        orders.put(order.getId(), order);
        return order;
    }

    public Flux<Order> orders(){
        return Flux.fromIterable(orders.values()).delayElements(Duration.ofMillis(128));
    }

}
