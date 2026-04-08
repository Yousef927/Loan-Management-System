package com.hagag.LoanManagementSystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Loan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double amount;
    private int durationMonths;
    private Status status;
    private String createdAt;

    @OneToMany
    private User user;
}
