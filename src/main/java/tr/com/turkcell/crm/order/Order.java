package tr.com.turkcell.crm.order;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order
{
    @Id
    private String id;
    private Date createdAt = new Date();
    private String customerId;
    private List<OrderLine> orderLines = new ArrayList<>();

    @Data
    public static class OrderLine
    {
        private String offerName;
        private List<OrderLineProperty> properties = new ArrayList<>();
    }

    @Data
    public static class OrderLineProperty
    {
        private String name;
        private String value;
    }
}
