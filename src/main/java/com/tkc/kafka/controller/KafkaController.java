package com.tkc.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tkc.kafka.service.KafKaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	private final KafKaProducerService producerService;

	@Autowired
	public KafkaController(KafKaProducerService producerService)
	{
		this.producerService = producerService;
	}

	@GetMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message)
	{
		this.producerService.sendMessage(message);
	}

}
