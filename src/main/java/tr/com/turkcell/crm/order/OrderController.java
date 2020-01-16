package tr.com.turkcell.crm.order;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tr.com.turkcell.crm.order.requests.OrderRequest;

@Controller
@RequestMapping(path = "/api")
public class OrderController
{
    final OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }


    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest)
    {
        return ResponseEntity.ok(orderService.createNewOrder(orderRequest));
    }
}
