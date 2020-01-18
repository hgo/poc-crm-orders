package tr.com.turkcell.crm.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tr.com.turkcell.crm.order.requests.OrderRequest;

@Mapper(componentModel = "spring")
public interface OrderMapper
{

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    Order map(OrderRequest request);

    OrderCreated mapToEvent(Order order);
}
