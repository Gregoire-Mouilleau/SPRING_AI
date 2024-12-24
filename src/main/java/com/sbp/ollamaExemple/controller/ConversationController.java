package com.sbp.ollamaExemple.controller;

import com.sbp.ollamaExemple.service.ConversationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    /**
     * Endpoint to start a new conversation.
     * @param request A JSON body containing "personality".
     * @return The key of the new conversation.
     */
    @PostMapping("/start")
    public ResponseEntity<String> startConversation(@RequestBody Map<String, String> request) {
        String personality = request.get("personality");
        String conversationKey = conversationService.startNewConversation(personality);
        return ResponseEntity.ok(conversationKey);
    }

    /**
     * Endpoint to handle user input in an existing conversation.
     * @param conversationId The key of the conversation.
     * @param request A JSON body containing "userMessage".
     * @return The AI's response.
     */
    @PostMapping("/{conversationId}/input")
    public ResponseEntity<String> handleUserInput(
            @PathVariable String conversationId,
            @RequestBody Map<String, String> request
    ) {
        String userMessage = request.get("userMessage");
        String response = conversationService.handleUserInput(conversationId, userMessage);
        return ResponseEntity.ok(response);
    }
}
