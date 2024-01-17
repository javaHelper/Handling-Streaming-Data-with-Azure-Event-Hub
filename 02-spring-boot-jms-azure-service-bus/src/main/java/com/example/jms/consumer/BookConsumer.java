package com.example.jms.consumer;

import com.example.jms.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class BookConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @JmsListener(destination = "demo-queue", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) throws JsonProcessingException {
        var emp = objectMapper.readValue(message, Book.class);
        LOGGER.info("Message received: {}", message);
    }
}