package eva.recipes.chapter5Reactive2.web;


import eva.recipes.chapter5Reactive2.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Mono<String> list(Model model){
        var orders  = orderService.orders();
        model.addAttribute("orders", orders);
        return Mono.just("orders/list");
    }
}
