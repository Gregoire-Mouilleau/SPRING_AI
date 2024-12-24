package com.sbp.ollamaExemple;

import com.sbp.ollamaExemple.model.Message;

import java.util.List;

public class Prompt {
    private final List<Message> messages;

    public Prompt(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
