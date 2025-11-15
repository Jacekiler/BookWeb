package com.jszarski.bookservice.service;

import com.jszarski.common.model.event.NotificationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class NotificationEventProducer {

    private static final String TOPIC = "notifications";

    private final KafkaTemplate<UUID, NotificationEvent> kafkaTemplate;

    public void send(NotificationEvent event) {
        var key = UUID.randomUUID();
        log.info("Sending NotificationEvent to topic \"{}\" with key \"{}\"", TOPIC, key);
        kafkaTemplate.send(TOPIC, key, event);
        log.info("Event {} sent.", key);
    }

}
