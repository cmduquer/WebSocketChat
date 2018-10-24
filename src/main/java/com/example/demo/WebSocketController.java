package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WebSocketController {

	private final SimpMessagingTemplate template;
	private ChatMessageRepository chatMessageRepository;
	private static List<ChatMessage> chatMessages;

	@Autowired
	WebSocketController(SimpMessagingTemplate template, ChatMessageRepository chatMessageRepository) {
		this.template = template;
		this.chatMessageRepository = chatMessageRepository;
		chatMessages = new ArrayList<ChatMessage>();
	}

	@MessageMapping("/send/message")
	public void onReceivedMesage(String message) {
		Date fecha = new Date();
		this.template.convertAndSend("/chat", new SimpleDateFormat("HH:mm:ss").format(fecha) + "- " + message);
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setMessage(message);
		chatMessage.setFecha(fecha);
		chatMessages.add(chatMessage);
		if (chatMessages.size() == 2) {
			chatMessageRepository.saveAll(chatMessages);
			chatMessages = new ArrayList<>();
		}

	}
}
