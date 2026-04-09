package com.hagag.LoanManagementSystem.DTOs;

import lombok.Data;

@Data
public class LoanRequestDTO {

    private double amount;
    private int durationMonths;

}
