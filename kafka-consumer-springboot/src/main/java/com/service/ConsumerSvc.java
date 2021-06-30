package com.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.model.Employee;

@Service
public class ConsumerSvc {

	@KafkaListener(topics = "first_topic", groupId = "first-app", containerFactory = "kafkaListenerContainerFactory")
	public void consumeStringMessage(String message) {
		System.out.println("String Message Consumed: " + message);

	}

	@KafkaListener(topics = "first_topic", groupId = "first-app", containerFactory = "empKafkaListenerContainerFactory")
	public void consumeEmployeeMessage(Employee emp) {
		System.out.println("Employee Message Consumed: " + emp.toString());

	}

}
