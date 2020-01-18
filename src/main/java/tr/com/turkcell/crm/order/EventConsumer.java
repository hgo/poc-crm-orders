package tr.com.turkcell.crm.order;

public interface EventConsumer
{
    void consume(String message);
}
