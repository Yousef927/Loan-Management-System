package com.hagag.LoanManagementSystem.exception;

public class LoanAlreadyRejected extends RuntimeException {
    public LoanAlreadyRejected(String message) {
        super(message);
    }
}
