package com.hagag.LoanManagementSystem.DTOs;

import com.hagag.LoanManagementSystem.entities.Status;
import lombok.Data;

@Data
public class LoanResponseDTO {

    private Integer id;
    private double amount;
    private int durationMonths;
    private Status status;
    private String createdAt;

}
