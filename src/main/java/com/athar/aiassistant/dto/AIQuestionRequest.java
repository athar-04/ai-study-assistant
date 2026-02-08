package com.athar.aiassistant.dto;

import jakarta.validation.constraints.NotBlank;

public class AIQuestionRequest {

    @NotBlank
    private String topic;

    @NotBlank
    private String difficulty;

    public String getTopic() {
        return topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    // (optional but good practice)
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
