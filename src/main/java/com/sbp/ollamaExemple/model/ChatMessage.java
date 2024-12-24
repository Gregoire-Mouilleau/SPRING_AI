package com.sbp.ollamaExemple.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String sender;

    @ManyToOne
    @JoinColumn(name = "conversation_id", nullable = false)
    private Conversation conversation;
}
