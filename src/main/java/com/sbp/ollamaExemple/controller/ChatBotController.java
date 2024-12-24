package com.sbp.ollamaExemple.controller;

import com.sbp.ollamaExemple.service.ChatBotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatbot")
public class ChatBotController {

    private final ChatBotService chatBotService;

    public ChatBotController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    @PostMapping("/{key}/input")
    public String handleUserMessage(@PathVariable String key, @RequestBody String userMessage) {
        return chatBotService.getResponse(key, userMessage);
    }
}
