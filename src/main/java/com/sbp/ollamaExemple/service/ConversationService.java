package com.sbp.ollamaExemple.service;

import com.sbp.ollamaExemple.model.ChatMessage;
import com.sbp.ollamaExemple.model.Conversation;
import com.sbp.ollamaExemple.repository.ConversationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public String startNewConversation(String personality) {
        Conversation conversation = new Conversation();
        conversation.setConversationKey(UUID.randomUUID().toString());
        conversation.setPersonality(personality);
        conversationRepository.save(conversation);
        return conversation.getConversationKey();
    }

    public Optional<Conversation> findConversationByKey(String conversationKey) {
        return conversationRepository.findByConversationKey(conversationKey);
    }

    public void addMessageToConversation(String conversationKey, ChatMessage message) {
        Optional<Conversation> conversationOpt = findConversationByKey(conversationKey);
        if (conversationOpt.isPresent()) {
            Conversation conversation = conversationOpt.get();
            message.setConversation(conversation);
            conversation.getMessages().add(message);
            conversationRepository.save(conversation);
        }
    }

    public String handleUserInput(String conversationId, String userMessage) {
        Optional<Conversation> conversationOpt = findConversationByKey(conversationId);

        if (conversationOpt.isEmpty()) {
            throw new IllegalArgumentException("Conversation not found for id: " + conversationId);
        }

        // Ajouter le message utilisateur à la conversation
        ChatMessage userMsg = new ChatMessage();
        userMsg.setContent(userMessage);
        userMsg.setSender("USER");
        addMessageToConversation(conversationId, userMsg);

        // Générer une réponse simulée
        String aiResponse = "Ceci est une réponse simulée pour: " + userMessage;

        // Ajouter la réponse de l'IA à la conversation
        ChatMessage aiMsg = new ChatMessage();
        aiMsg.setContent(aiResponse);
        aiMsg.setSender("AI");
        addMessageToConversation(conversationId, aiMsg);

        return aiResponse;
    }
}
