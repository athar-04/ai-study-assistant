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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@Tag(
    name = "Study Sessions",
    description = "APIs related to creating and managing study sessions"
)
@RestController
@RequestMapping("/api/sessions")
public class StudySessionController {

    private final StudySessionService service;

    public StudySessionController(StudySessionService service) {
        this.service = service;
    }

     @Operation(
        summary = "Create a study session",
        description = "Creates a new study session with topic and difficulty level"
    )

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
     @Operation(
        summary = "Get all study sessions",
        description = "Fetches all study sessions without pagination"
    )

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
    
     @Operation(
        summary = "Get paginated study sessions",
        description = "Fetches study sessions with pagination and sorting support"
    )
    
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
