package com.zs.controller;

import com.zs.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zs.bean.CustomMessage;

@RestController
public class ProducerController {

	@Autowired
	private MessageProducerService service;
	
	@PostMapping("/publish")
	public String publishMsg(@RequestBody CustomMessage msg) {
		service.sendMessage(msg);
		return "Message published";
	}
}
