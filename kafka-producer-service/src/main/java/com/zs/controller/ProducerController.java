package com.zs.controller;

import com.zs.service.MyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@Autowired
	private MyProducer producer;
	
	@PostMapping(value = "/publish/{message}")
	public String publish(@PathVariable String message) {
		producer.sendMessage(message);
		return "Message published";
	}
}
