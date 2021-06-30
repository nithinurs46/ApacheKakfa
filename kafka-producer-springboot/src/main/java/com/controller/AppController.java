package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;

@RestController
@RequestMapping("kafka")
public class AppController {

	public static final String TOPIC = "first_topic";

	@Autowired
	KafkaTemplate<String, String> template;

	@GetMapping("/produce/{message}")
	public String produceMessage(@PathVariable String message) {
		template.send(TOPIC, message);
		return "Message Produced";
	}

	@Autowired
	KafkaTemplate<String, Employee> empTemplate;

	@GetMapping("/produceEmp/{name}")
	public String produceEmpMessage(@PathVariable String name) {
		Employee emp = new Employee("1", name, "1100");
		empTemplate.send(TOPIC, emp);
		return "Employee Message Produced";
	}
}
