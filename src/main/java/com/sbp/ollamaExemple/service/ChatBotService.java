package com.sbp.ollamaExemple.service;

import com.sbp.ollamaExemple.model.ChatMessage;
import org.springframework.stereotype.Service;

@Service
public class ChatBotService {

    private final ConversationService conversationService;

    public ChatBotService(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    public String getResponse(String conversationKey, String userMessage) {
        ChatMessage userMsg = new ChatMessage();
        userMsg.setContent(userMessage);
        userMsg.setSender("USER");
        conversationService.addMessageToConversation(conversationKey, userMsg);

        // Simuler une réponse IA
        String aiResponse = "Ceci est une réponse simulée.";
        ChatMessage aiMsg = new ChatMessage();
        aiMsg.setContent(aiResponse);
        aiMsg.setSender("AI");
        conversationService.addMessageToConversation(conversationKey, aiMsg);

        return aiResponse;
    }
}
