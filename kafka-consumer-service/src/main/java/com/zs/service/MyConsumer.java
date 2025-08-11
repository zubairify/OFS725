package com.zs.service;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyConsumer {

	@KafkaListener(topics = "my-topic", groupId = "group_id")
	public void consume(String message) throws IOException {
		System.out.println("Message consumed: " + message);
	}
}
