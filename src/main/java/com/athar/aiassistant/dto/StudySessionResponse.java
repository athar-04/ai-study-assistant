package com.athar.aiassistant.dto;

import java.time.LocalDateTime;

public class StudySessionResponse {

    private String id;
    private String topic;
    private int durationMinutes;
    private String difficulty;
    private LocalDateTime createdAt;

    public StudySessionResponse(
            String id,
            String topic,
            int durationMinutes,
            String difficulty,
            LocalDateTime createdAt) {

        this.id = id;
        this.topic = topic;
        this.durationMinutes = durationMinutes;
        this.difficulty = difficulty;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
