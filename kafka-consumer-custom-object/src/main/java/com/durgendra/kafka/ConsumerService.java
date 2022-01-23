package com.durgendra.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@KafkaListener(topics = "${kafka.topic}")
	public void receive(@Payload CustomObject data,
			@Headers MessageHeaders messageHeaders) {

		log.info("- - - - - - - - - - - - - - -");
		log.info("received message='{}'", data);
		messageHeaders.keySet().forEach(key -> {
			Object value = messageHeaders.get(key);
			if (key.equals("X-Custom-Header")){
				log.info("{}: {}", key, new String((byte[])value));
			} else {
				log.info("{}: {}", key, value);
			}
		});

	}

	@KafkaListener(topics = "${kafka.topic}")
	public void receive(@Payload String data,
			@Header(KafkaHeaders.OFFSET) Long offset,
			@Header(KafkaHeaders.CONSUMER) KafkaConsumer<String, String> consumer,
			@Header(KafkaHeaders.TIMESTAMP_TYPE) String timestampType,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey,
			@Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp,
			@Header("X-Custom-Header") String customHeader) {

		log.info("- - - - - - - - - - - - - - -");
		log.info("received message='{}'", data);
		log.info("consumer: {}", consumer);
		log.info("topic: {}", topic);
		log.info("message key: {}", messageKey);
		log.info("partition id: {}", partitionId);
		log.info("offset: {}", offset);
		log.info("timestamp type: {}", timestampType);
		log.info("timestamp: {}", timestamp);
		log.info("custom header: {}", customHeader);
	}

}
