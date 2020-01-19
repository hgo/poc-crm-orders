package tr.com.turkcell.crm.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        value = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration")
class OrderApplicationTests
{

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads()
    {
    }


    @Test
    public void createOrder()
    {
        String body = "{ \"customerId\" : \"01193010-07d1-4b76-bcc0-17346e913b87\", \"orderLines\": [ { \"offerName\" : \"Fiber2 Muhtesem Uclu\", \"properties\": [ { \"name\" : \"UAVT\", \"value\" : \"1235295894\" } ] } ] }";

        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<String> request = new HttpEntity<>(body, headers);
        final ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:" + port + "/api/orders", request, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
