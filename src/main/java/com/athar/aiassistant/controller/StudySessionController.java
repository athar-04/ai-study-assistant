package com.athar.aiassistant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.athar.aiassistant.dto.CreateStudySessionRequest;
import com.athar.aiassistant.dto.StudySessionResponse;
import com.athar.aiassistant.response.ApiResponse;
import com.athar.aiassistant.service.StudySessionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sessions")
public class StudySessionController {

    private final StudySessionService service;

    public StudySessionController(StudySessionService service) {
        this.service = service;
    }

    // Create Study Session
    @PostMapping
    public ApiResponse<StudySessionResponse> createSession(
            @Valid @RequestBody CreateStudySessionRequest request) {

        StudySessionResponse response = service.createSession(request);

        return new ApiResponse<>(
                true,
                "Study session created successfully",
                response
        );
    }

    //Get all sessions (non-paginated)
    @GetMapping
    public ApiResponse<List<StudySessionResponse>> getAllSessions() {

        List<StudySessionResponse> sessions = service.getAllSessions();

        return new ApiResponse<>(
                true,
                "Study sessions fetched successfully",
                sessions
        );
    }

    // Get paginated & sorted sessions (Day 4 feature)
    @GetMapping("/paged")
    public ApiResponse<?> getPagedSessions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy) {

        return new ApiResponse<>(
                true,
                "Paged study sessions fetched successfully",
                service.getSessionsPaged(page, size, sortBy)
        );
    }
}
