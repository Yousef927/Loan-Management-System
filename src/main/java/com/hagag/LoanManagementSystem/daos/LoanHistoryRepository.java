package com.hagag.LoanManagementSystem.daos;

import com.hagag.LoanManagementSystem.entities.LoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanHistoryRepository extends JpaRepository<LoanHistory , Integer> {
    List<LoanHistory> findByLoanId(Integer loanId);
}
