package com.athar.aiassistant.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateStudySessionRequest {

    @NotBlank(message = "Topic must not be blank")
    private String topic;

    @Min(value = 1, message = "Duration must be greater than 0")
    private int durationMinutes;

    private String difficulty;

    public String getTopic() {
        return topic;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
