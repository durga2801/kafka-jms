package com.durgendra.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	
	@Value("${kafka.topic}")
	private String kafkaTopic;
	
	@Autowired
	private KafkaTemplate<String, CustomObject> template;
	
	public String publish(CustomObject publishData) {
		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("transactionId", UUID.randomUUID());
		headerMap.put(KafkaHeaders.TOPIC, kafkaTopic);
		MessageHeaders headers = new MessageHeaders(headerMap);
		Message<CustomObject> message = MessageBuilder.createMessage(publishData, headers);
		template.send(message);
		return "Published";
		
	}

}
