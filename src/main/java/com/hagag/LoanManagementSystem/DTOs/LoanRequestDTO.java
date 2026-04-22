package com.hagag.LoanManagementSystem.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoanRequestDTO {

    @NotNull
    @Min(value = 800000 , message = "Minimum loan amount is 800,000")
    private double amount;

    @Min(value = 12 , message = "Minimum loan duration is 12 months")
    private int durationMonths;

}
