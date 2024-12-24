package com.sbp.ollamaExemple.model;

public abstract class Message {
    private final String content;

    protected Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class SystemMessage extends Message {
    public SystemMessage(String content) {
        super(content);
    }
}

class UserMessage extends Message {
    public UserMessage(String content) {
        super(content);
    }
}