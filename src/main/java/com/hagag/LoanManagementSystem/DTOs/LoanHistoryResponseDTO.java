package com.hagag.LoanManagementSystem.DTOs;

import com.hagag.LoanManagementSystem.entities.Action;
import lombok.Data;

@Data
public class LoanHistoryResponseDTO {

    Action action;
    String actedBy;
    String actedAt;
}
