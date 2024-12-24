package com.sbp.ollamaExemple.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "conversation_key")
    private String conversationKey;

    private String personality;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "conversation_id")
    private List<ChatMessage> messages = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "conversation_settings", joinColumns = @JoinColumn(name = "conversation_id"))
    @MapKeyColumn(name = "setting_key")
    @Column(name = "setting_value")
    private Map<String, String> settings = new HashMap<>();
}
