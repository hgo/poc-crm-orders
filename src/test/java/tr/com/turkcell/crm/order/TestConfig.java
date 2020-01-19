package tr.com.turkcell.crm.order;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfig
{

    @Bean
    @Primary
    public OrderRepository OrderRepository()
    {
        return Mockito.mock(OrderRepository.class);
    }


    @Bean
    @Primary
    public EventConsumer eventConsumer()
    {
        return Mockito.mock(EventConsumer.class);
    }

    @Bean
    @Primary
    public EventProducer eventProducer()
    {
        return Mockito.mock(EventProducer.class);
    }

}
