package com.athar.aiassistant.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "study_sessions")
public class StudySession {

    @Id
    private String id;

    @NotBlank(message = "Topic must not be blank")
    private String topic;

    @Min(value = 1, message = "Duration must be greater than 0")
    private int durationMinutes;

    private String difficulty;

    private LocalDateTime createdAt;

    public StudySession() {
        this.createdAt = LocalDateTime.now();
    }

    public StudySession(String topic, int durationMinutes, String difficulty) {
        this.topic = topic;
        this.durationMinutes = durationMinutes;
        this.difficulty = difficulty;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
