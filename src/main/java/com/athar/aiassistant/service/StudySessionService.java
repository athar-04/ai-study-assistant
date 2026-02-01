package com.athar.aiassistant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.athar.aiassistant.dto.CreateStudySessionRequest;
import com.athar.aiassistant.dto.StudySessionResponse;
import com.athar.aiassistant.model.StudySession;
import com.athar.aiassistant.repository.StudySessionRepository;

@Service
public class StudySessionService {

    private final StudySessionRepository repository;

    public StudySessionService(StudySessionRepository repository) {
        this.repository = repository;
    }

    // Create session
    public StudySessionResponse createSession(CreateStudySessionRequest request) {

        StudySession session = new StudySession(
                request.getTopic(),
                request.getDurationMinutes(),
                request.getDifficulty()
        );

        StudySession saved = repository.save(session);

        return mapToResponse(saved);
    }

    // Get all sessions (non-paginated)
    public List<StudySessionResponse> getAllSessions() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Get paginated & sorted sessions (Day 4 feature)
    public Page<StudySessionResponse> getSessionsPaged(
            int page,
            int size,
            String sortBy) {

        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).descending()
        );

        return repository.findAll(pageRequest)
                .map(this::mapToResponse);
    }

    // Entity → DTO mapper
    private StudySessionResponse mapToResponse(StudySession session) {
        return new StudySessionResponse(
                session.getId(),
                session.getTopic(),
                session.getDurationMinutes(),
                session.getDifficulty(),
                session.getCreatedAt()
        );
    }
}
