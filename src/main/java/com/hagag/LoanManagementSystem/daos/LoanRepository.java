package com.hagag.LoanManagementSystem.daos;

import com.hagag.LoanManagementSystem.entities.Loan;
import com.hagag.LoanManagementSystem.entities.Status;
import com.hagag.LoanManagementSystem.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {


    Page<Loan> findByUser(User user , Pageable pageable);


    Page<Loan> findByUserAndStatus(User user , Status status , Pageable pageable);
}
