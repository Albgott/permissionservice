package com.albgott.permissionservice.shared.infrastructure.event.rabbitMq;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumerAutoStarter {

    private final RabbitMqDomainEventsConsumer consumer;

    public RabbitMqConsumerAutoStarter(RabbitMqDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startRabbitMqConsumers(){
        consumer.consume();
    }
}
