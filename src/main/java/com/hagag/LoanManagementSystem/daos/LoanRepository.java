package com.hagag.LoanManagementSystem.daos;

import com.hagag.LoanManagementSystem.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
