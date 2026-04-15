package com.hagag.LoanManagementSystem.daos;

import com.hagag.LoanManagementSystem.entities.Loan;
import com.hagag.LoanManagementSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {


    List<Loan> findByUser(User user);
}
