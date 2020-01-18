package tr.com.turkcell.crm.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.turkcell.crm.order.requests.OrderRequest;

@Service
public class OrderService
{
    final OrderRepository orderRepository;
    final OrderMapper orderMapper;
    final EventProducer eventProducer;
    final ObjectMapper objectMapper;

    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, EventProducer eventProducer, ObjectMapper objectMapper)
    {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.eventProducer = eventProducer;
        this.objectMapper = objectMapper;
    }

    public Order createNewOrder(OrderRequest orderRequest)
    {
        Order order = orderMapper.map(orderRequest);
        order = orderRepository.save(order);
        OrderCreated event = orderMapper.mapToEvent(order);
        try
        {
            eventProducer.sendMessage(objectMapper.writeValueAsString(event));
        }
        catch (JsonProcessingException e)
        {
            //POC kapsaminda Schema Registry kullanilmamistir
            logger.error("unable to process json" , e);
        }
        return order;
    }

    public void statusChanged(OrderStatusChanged statusChanged)
    {
        orderRepository.findById(statusChanged.getId())
                .ifPresent(order -> {
                    order.setStatus(statusChanged.getStatus());
                    orderRepository.save(order);
                });
    }
}
