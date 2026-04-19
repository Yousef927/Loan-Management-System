package com.hagag.LoanManagementSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String message;
    private Integer status;
    private LocalDateTime timestamp;

    public static ErrorResponse buildErrorResponse(String message, HttpStatus status) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setMessage(message);
        errorResponse.setStatus(status.value());
        errorResponse.setTimestamp(LocalDateTime.now());

        return errorResponse;
    }
}
