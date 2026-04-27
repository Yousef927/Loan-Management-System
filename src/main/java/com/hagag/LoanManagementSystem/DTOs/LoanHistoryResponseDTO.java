package com.hagag.LoanManagementSystem.DTOs;

import com.hagag.LoanManagementSystem.entities.Action;
import com.hagag.LoanManagementSystem.entities.LoanHistory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanHistoryResponseDTO {

    Action action;
    String actedBy;
    LocalDateTime actedAt;

    public static LoanHistoryResponseDTO buildResponseFromHistory(LoanHistory history) {
        LoanHistoryResponseDTO response = new LoanHistoryResponseDTO();
        response.setAction(history.getAction());
        response.setActedBy(history.getActedBy());
        response.setActedAt(history.getActedAt());
        return response;
    }
}
