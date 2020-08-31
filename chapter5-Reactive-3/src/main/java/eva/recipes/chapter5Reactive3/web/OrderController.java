package eva.recipes.chapter5Reactive3.web;


import eva.recipes.chapter5Reactive3.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

   /* @GetMapping
    public Mono<String> list(Model model){
        var orders  = orderService.orders();
        model.addAttribute("orders", orders);
        return Mono.just("orders/list");
    }*/

    @GetMapping
    public Mono<String> list(Model model){
        var orders = orderService.orders();
        model.addAttribute("orders", new ReactiveDataDriverContextVariable(orders, 2));
        return Mono.just("orders/list");
    }
}
