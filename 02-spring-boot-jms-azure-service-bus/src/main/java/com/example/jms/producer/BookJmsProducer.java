package com.example.jms.producer;


import com.example.jms.constant.AppConst;
import com.example.jms.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookJmsProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Book book) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(book);
        jmsTemplate.convertAndSend(AppConst.QUEUE_NAME, json);
    }
}