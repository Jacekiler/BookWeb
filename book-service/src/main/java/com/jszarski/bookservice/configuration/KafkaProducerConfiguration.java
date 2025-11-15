package com.jszarski.bookservice.configuration;

import com.jszarski.common.model.event.NotificationEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.UUIDSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;
import java.util.UUID;

@Configuration
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<UUID, NotificationEvent> notificationEventProducerFactory(){
        return new DefaultKafkaProducerFactory<>(config());
    }

    @Bean
    public KafkaTemplate<UUID, NotificationEvent> notificationEventKafkaTemplate(){
        return new KafkaTemplate<>(notificationEventProducerFactory());
    }

    private Map<String, Object> config(){
        return Map.of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, UUIDSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
        );
    }
}
