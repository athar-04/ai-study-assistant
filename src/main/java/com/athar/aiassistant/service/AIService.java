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

    public String generateInterviewQuestion(String topic, String difficulty) {

        String prompt = "Generate a " + difficulty +
                " level interview question on " + topic + ".";

        Map<String, Object> requestBody = Map.of(
                "model", model,
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        Map response = webClient.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        // Extract AI response safely
        List<Map> choices = (List<Map>) response.get("choices");
        Map message = (Map) choices.get(0).get("message");

        return message.get("content").toString();
    }
}
