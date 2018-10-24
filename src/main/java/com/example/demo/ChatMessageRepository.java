package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "chatmessages", path = "chatmessages")
@CrossOrigin(origins = "http://localhost:4200")
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

}
