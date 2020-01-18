package tr.com.turkcell.crm.order.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tr.com.turkcell.crm.order.EventConsumer;
import tr.com.turkcell.crm.order.OrderService;
import tr.com.turkcell.crm.order.OrderStatusChanged;
import tr.com.turkcell.crm.order.Topics;

@Service
@Lazy(false)
public class EventConsumerImpl implements EventConsumer
{

    private final OrderService orderService;
    private final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @Autowired
    public EventConsumerImpl(OrderService orderService, ObjectMapper objectMapper)
    {
        this.orderService = orderService;
        this.objectMapper = objectMapper;
    }

    @Override
    @KafkaListener(topics = Topics.ORDERS, groupId = "group_id")
    public void consume(String message)
    {

        try
        {
            final OrderStatusChanged statusChanged = objectMapper.readValue(message, OrderStatusChanged.class);

            orderService.statusChanged(statusChanged);
        }
        catch (JsonProcessingException e)
        {
            //POC kapsaminda Schema Registry kullanilmamistir
            logger.error("unable to process json", e);
        }
        logger.info(String.format("$$ -> Consumed Message -> %s", message));

    }


}
