package com.example.demo;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharMessageController {
	ChatMessageRepository chatMessageRepository;

	public CharMessageController(ChatMessageRepository chatMessageRepository) {
		this.chatMessageRepository = chatMessageRepository;
	}
	
	@GetMapping("/chats")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<ChatMessage> coolCars() {
        return chatMessageRepository.findAll();
    }
	

}
