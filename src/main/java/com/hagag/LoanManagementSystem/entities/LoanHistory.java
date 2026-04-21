package com.hagag.LoanManagementSystem.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
public class LoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Status action;


    private String actedBy;
    private LocalDateTime actedAt;

    @ManyToOne
    private Loan loan;

    public static LoanHistory buildLoanHistory(Loan loan, Status action, String actedBy) {
        LoanHistory history = new LoanHistory();
        history.setLoan(loan);
        history.setAction(action);
        history.setActedBy(actedBy);
        history.setActedAt(LocalDateTime.now());
        return history;
    }
}
