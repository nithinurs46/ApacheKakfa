package com.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.model.Employee;

@Configuration
public class KafkaConfiguration {

	@Bean
	public ProducerFactory<String, Employee> empProducerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		String bootstrapServer = "127.0.0.1:9092";
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
		return new DefaultKafkaProducerFactory<String, Employee>(config);
	}

	@Bean
	public KafkaTemplate<String, Employee> empTemplate() {
		return new KafkaTemplate<String, Employee>(empProducerFactory());
	}

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		String bootstrapServer = "127.0.0.1:9092";
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return new DefaultKafkaProducerFactory<String, String>(config);
	}

	@Bean
	public KafkaTemplate<String, String> template() {
		return new KafkaTemplate<String, String>(producerFactory());
	}

}
