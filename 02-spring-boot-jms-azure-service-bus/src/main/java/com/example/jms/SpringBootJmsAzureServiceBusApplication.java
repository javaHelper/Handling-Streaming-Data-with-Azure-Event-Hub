package com.example.jms;

import com.example.jms.model.Book;
import com.example.jms.producer.BookJmsProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootJmsAzureServiceBusApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmsAzureServiceBusApplication.class, args);
	}

	@Autowired
	private BookJmsProducer jmsProducer;

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = new ArrayList<>();
		books.add(Book.builder().id(1L).title("White Noise").price(new BigDecimal("9.99")).publishDate(LocalDate.now()).build());
		books.add(Book.builder().id(1L).title("American Psycho").price(new BigDecimal("8.99")).publishDate(LocalDate.now()).build());
		books.add(Book.builder().id(1L).title("A little life").price(new BigDecimal("7.99")).publishDate(LocalDate.now()).build());

		books.forEach(book -> {
			try {
				jmsProducer.sendMessage(book);
			} catch (JsonProcessingException ex) {
				ex.printStackTrace();
			}
		});
	}
}