package com.sbp.ollamaExemple.model;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.io.IOException;

// Marque cette classe comme un Bean Spring
@Component
public class OllamaChatModel {

    @PostConstruct
    public void init() {
        System.out.println("OllamaChatModel bean initialized");
    }

    public Flux<String> stream(String prompt) {
        // Implémentation du streaming ici
        return Flux.just("Réponse simulée pour le prompt : " + prompt);
    }

    public String loadPrompt(String fileName) throws IOException {
        // Simule la lecture d'un fichier de prompt
        return "Contenu du prompt depuis " + fileName;
    }
}
