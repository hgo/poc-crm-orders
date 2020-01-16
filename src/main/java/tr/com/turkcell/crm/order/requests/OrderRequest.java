package tr.com.turkcell.crm.order.requests;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderRequest
{
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
