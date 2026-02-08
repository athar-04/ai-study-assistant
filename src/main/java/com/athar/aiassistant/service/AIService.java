package com.athar.aiassistant.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AIService {

    private final WebClient webClient;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.model}")
    private String model;

    public AIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    /**
 * Mock AI implementation.
 * Real OpenAI integration exists but is disabled due to billing constraints.
 */
public String generateInterviewQuestion(String topic, String difficulty) {

    return switch (difficulty.toLowerCase()) {
        case "easy" ->
                "What is " + topic + " and why is it used?";
        case "medium" ->
                "Can you explain the core concepts of " + topic + " and how it works internally?";
        case "hard" ->
                "Explain advanced concepts of " + topic + " and discuss real-world challenges.";
        default ->
                "Explain " + topic + " in detail.";
    };
}

}
