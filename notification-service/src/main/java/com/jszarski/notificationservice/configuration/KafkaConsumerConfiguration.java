package com.jszarski.notificationservice.configuration;

import com.jszarski.common.model.event.NotificationEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.UUIDDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;
import java.util.UUID;

@Configuration
public class KafkaConsumerConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<UUID, NotificationEvent> notificationEventConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(config(), new UUIDDeserializer(), new JsonDeserializer<>(NotificationEvent.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<UUID, NotificationEvent> notificationEventConcurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<UUID, NotificationEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(notificationEventConsumerFactory());
        return factory;
    }

    private Map<String, Object> config(){
        return Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, UUIDDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class,
                ConsumerConfig.GROUP_ID_CONFIG, groupId
        );
    }
}
