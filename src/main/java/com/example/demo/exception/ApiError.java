package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private final int status;
    private final String error;
    private final String message;
    private final LocalDateTime timestamp;

    // Only populated for validation errors
    private final Map<String, String> fieldErrors;
}
