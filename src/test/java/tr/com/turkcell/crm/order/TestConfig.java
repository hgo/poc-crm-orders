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

}
