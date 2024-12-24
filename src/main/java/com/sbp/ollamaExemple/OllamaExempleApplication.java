package com.sbp.ollamaExemple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(scanBasePackages = "com.sbp.ollamaExemple")
public class OllamaExempleApplication {
	public static void main(String[] args) {
		SpringApplication.run(OllamaExempleApplication.class, args);
	}


	@Bean
	CommandLineRunner init(WebClient.Builder builder) {
		return args -> {
			System.out.println("WebClient.Builder bean is available: " + (builder != null));
		};
	}
}
