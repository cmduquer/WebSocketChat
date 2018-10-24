package com.example.demo;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(ChatMessageRepository repository) {
        return args -> {
            Stream.of("Prueba 1", "Mensaje 2").forEach(name -> {
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.setMessage(name);
                chatMessage.setFecha(new Date());
                repository.save(chatMessage);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
