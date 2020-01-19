package tr.com.turkcell.crm.order.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import tr.com.turkcell.crm.order.EventProducer;
import tr.com.turkcell.crm.order.Topics;

class EventProducerImpl implements EventProducer
{

    private static final Logger logger = LoggerFactory.getLogger(EventProducerImpl.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    EventProducerImpl(KafkaTemplate<String, String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message)
    {
        logger.info(String.format("$$ -> Producing message --> %s", message));
        this.kafkaTemplate.send(Topics.ASSETS, message);
    }
}
