package com.athar.aiassistant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athar.aiassistant.model.StudySession;
import com.athar.aiassistant.repository.StudySessionRepository;

@RestController
@RequestMapping("/api/sessions")
public class StudySessionController {

    private final StudySessionRepository repository;

    public StudySessionController(StudySessionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public StudySession createSession(@RequestBody StudySession session) {
        return repository.save(session);
    }

    @GetMapping
    public List<StudySession> getAllSessions() {
        return repository.findAll();
    }
}
