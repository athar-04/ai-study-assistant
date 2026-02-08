package com.athar.aiassistant.controller;

import com.athar.aiassistant.dto.AIQuestionRequest;
import com.athar.aiassistant.dto.AIQuestionResponse;
import com.athar.aiassistant.response.ApiResponse;
import com.athar.aiassistant.service.AIService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
    name = "AI Features",
    description = "APIs related to AI-powered interview preparation"
)
@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @Operation(
        summary = "Generate interview question",
        description = "Generates an interview question based on topic and difficulty using AI logic"
    )
    @PostMapping("/interview-question")
    public ApiResponse<AIQuestionResponse> generateInterviewQuestion(
            @Valid @RequestBody AIQuestionRequest request) {

        String question = aiService.generateInterviewQuestion(
                request.getTopic(),
                request.getDifficulty()
        );

        return new ApiResponse<>(
                true,
                "AI interview question generated successfully",
                new AIQuestionResponse(question)
        );
    }
}
