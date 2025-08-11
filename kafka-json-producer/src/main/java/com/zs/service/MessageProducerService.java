package com.zs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.zs.bean.CustomMessage;

@Service
public class MessageProducerService {

	@Autowired
	private KafkaTemplate<String, CustomMessage> kafkaTemplate;
	
	public void sendMessage(CustomMessage cm) {
		kafkaTemplate.send("my-topic", cm);
	}
	
}
