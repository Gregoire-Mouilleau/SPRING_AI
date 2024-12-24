package com.sbp.ollamaExemple.repository;

import com.sbp.ollamaExemple.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    Optional<Conversation> findByConversationKey(String conversationKey);
}
