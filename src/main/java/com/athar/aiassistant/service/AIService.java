package com.athar.aiassistant.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String generateInterviewQuestion(String topic, String difficulty) {

        String basePrompt = switch (difficulty.toLowerCase()) {
            case "easy" -> "Explain basic concepts of ";
            case "medium" -> "Explain intermediate concepts of ";
            case "hard" -> "Explain advanced concepts of ";
            default -> "Explain concepts of ";
        };

        return basePrompt + topic + " that are commonly asked in interviews.";
    }
}
