package com.hagag.LoanManagementSystem.daos;

import com.hagag.LoanManagementSystem.entities.LoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanHistoryRepository extends JpaRepository<LoanHistory , Integer> {
}
