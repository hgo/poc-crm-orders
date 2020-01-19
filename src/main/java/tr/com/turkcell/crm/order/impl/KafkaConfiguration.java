package tr.com.turkcell.crm.order.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import tr.com.turkcell.crm.order.EventConsumer;
import tr.com.turkcell.crm.order.EventProducer;
import tr.com.turkcell.crm.order.OrderService;

@Configuration
@Profile("!test")
public class KafkaConfiguration
{
    @Bean
    EventProducer eventProducer(KafkaTemplate<String, String> kafkaTemplate)
    {
        return new EventProducerImpl(kafkaTemplate);
    }

    @Bean
    @Lazy(false)
    EventConsumer eventConsumer(OrderService orderService, ObjectMapper objectMapper)
    {
        return new EventConsumerImpl(orderService, objectMapper);
    }

}
