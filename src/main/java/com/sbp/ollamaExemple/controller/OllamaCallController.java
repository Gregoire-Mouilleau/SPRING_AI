package com.sbp.ollamaExemple.controller;

import com.sbp.ollamaExemple.service.ConversationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ollama")
public class OllamaCallController {

    private final ConversationService conversationService;

    public OllamaCallController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/{conversationId}/ask")
    public String askQuestion(@PathVariable String conversationId, @RequestBody String question) {
        return conversationService.handleUserInput(conversationId, question);
    }
}
