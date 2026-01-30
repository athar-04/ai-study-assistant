package com.athar.aiassistant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athar.aiassistant.model.StudySession;
import com.athar.aiassistant.service.StudySessionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sessions")
public class StudySessionController {

    private final StudySessionService service;

    public StudySessionController(StudySessionService service) {
        this.service = service;
    }

    @PostMapping
    public StudySession createSession(@Valid @RequestBody StudySession session) {
        return service.createSession(session);
    }

    @GetMapping
    public List<StudySession> getAllSessions() {
        return service.getAllSessions();
    }
}
