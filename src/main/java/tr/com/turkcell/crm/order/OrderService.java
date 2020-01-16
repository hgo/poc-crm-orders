package tr.com.turkcell.crm.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.turkcell.crm.order.requests.OrderRequest;

@Service
public class OrderService
{
    final OrderRepository orderRepository;
    final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper)
    {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public Order createNewOrder(OrderRequest orderRequest)
    {
        Order order = orderMapper.map(orderRequest);
        order = orderRepository.save(order);
        //TODO : event atilacak
        return order;
    }
}
