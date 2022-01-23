package com.durgendra.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class KafkaController {
	
	@Autowired
	private KafkaService service;
	
	@PostMapping("/customData")
	private String publishData(@RequestBody CustomObject publishData) {
		return service.publish(publishData);
	}

}
