package tr.com.turkcell.crm.order;

public interface EventProducer
{
    void sendMessage(String message);
}
