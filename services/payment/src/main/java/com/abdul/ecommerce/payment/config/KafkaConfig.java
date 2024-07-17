package com.abdul.ecommerce.payment.config;

import com.abdul.ecommerce.payment.dto.PaymentConfirmation;
import com.fasterxml.jackson.databind.JsonSerializer;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder
                .name("payments")
                .build();
    }

    @Bean
    public ProducerFactory<String, PaymentConfirmation> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerProps());
    }

    @Bean
    public KafkaTemplate<String, PaymentConfirmation> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    private Map<String, Object> producerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        props.put("spring.json.type.mapping",
                "paymentConfirmation:com.abdul.ecommerce.payment.dto.PaymentConfirmation");
        return props;
    }
}
