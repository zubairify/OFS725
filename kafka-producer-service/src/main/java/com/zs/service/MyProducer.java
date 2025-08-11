package com.zs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyProducer {

	@Autowired
	private KafkaTemplate<String, String> template;
	
	private static final String TOPIC = "my-topic";
	
	public void sendMessage(String message) {
		template.send(TOPIC, message);
	}
}
