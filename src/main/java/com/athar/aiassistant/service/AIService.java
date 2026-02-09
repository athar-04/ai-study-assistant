package com.athar.aiassistant.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AIService {

    private final WebClient webClient;

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.base-url}")
    private String baseUrl;

    @Value("${gemini.model}")
    private String model;

    public AIService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public String generateInterviewQuestion(String topic, String difficulty) {

        String prompt = String.format(
                "Generate a %s level interview question on %s. Return only the question text.",
                difficulty, topic
        );

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );

        String url = baseUrl + "/" + model + ":generateContent?key=" + apiKey;

        try {
            Map response = webClient.post()
                    .uri(url)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            return extractText(response);

        } catch (Exception e) {
            e.printStackTrace();
            return "Gemini API error: " + e.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    private String extractText(Map response) {

        if (response == null) return "No response from Gemini";

        List<Map> candidates = (List<Map>) response.get("candidates");
        if (candidates == null || candidates.isEmpty()) {
            return "No candidates returned";
        }

        Map content = (Map) candidates.get(0).get("content");
        List<Map> parts = (List<Map>) content.get("parts");

        return parts.get(0).get("text").toString().trim();
    }
}
