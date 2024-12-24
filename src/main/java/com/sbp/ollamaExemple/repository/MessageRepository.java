package com.sbp.ollamaExemple.repository;

import com.sbp.ollamaExemple.model.ChatMessage;
import com.sbp.ollamaExemple.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByConversation(Conversation conversation);
}
