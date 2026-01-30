package com.athar.aiassistant.service;

import com.athar.aiassistant.model.StudySession;
import com.athar.aiassistant.repository.StudySessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudySessionService {

    private final StudySessionRepository repository;

    public StudySessionService(StudySessionRepository repository) {
        this.repository = repository;
    }

    public StudySession createSession(StudySession session) {
        return repository.save(session);
    }

    public List<StudySession> getAllSessions() {
        return repository.findAll();
    }
}
