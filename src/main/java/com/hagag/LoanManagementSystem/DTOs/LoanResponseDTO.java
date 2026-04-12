package com.hagag.LoanManagementSystem.DTOs;

import com.hagag.LoanManagementSystem.entities.Loan;
import com.hagag.LoanManagementSystem.entities.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanResponseDTO {

    private Integer id;
    private double amount;
    private int durationMonths;
    private Status status;
    private LocalDateTime createdAt;

    public static LoanResponseDTO buildResponseFromLoan(Loan loan) {
        LoanResponseDTO response = new LoanResponseDTO();
        response.setId(loan.getId());
        response.setAmount(loan.getAmount());
        response.setDurationMonths(loan.getDurationMonths());
        response.setStatus(loan.getStatus());
        response.setCreatedAt(loan.getCreatedAt());
        return response;
    }

}
