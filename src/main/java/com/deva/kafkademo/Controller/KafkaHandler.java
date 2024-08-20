package com.deva.kafkademo.Controller;

import com.deva.kafkademo.services.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaHandler {
    private final KafkaProducer kafkaProducer;
    public KafkaHandler(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("/publish")
    public String publishMessage(@RequestParam String message) {
        kafkaProducer.sendMessage("my-topic", message);
        return "Message published!";
    }
}
