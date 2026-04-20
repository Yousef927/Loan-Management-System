package com.hagag.LoanManagementSystem.exception;

public class LoanAlreadyApproved extends RuntimeException {
    public LoanAlreadyApproved(String message) {
        super(message);
    }
}
