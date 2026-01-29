package com.athar.aiassistant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.athar.aiassistant.model.StudySession;

@Repository
public interface StudySessionRepository
        extends MongoRepository<StudySession, String> {
}
