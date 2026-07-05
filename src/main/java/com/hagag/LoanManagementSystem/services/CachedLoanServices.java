package com.hagag.LoanManagementSystem.services;

import com.hagag.LoanManagementSystem.daos.LoanRepository;
import com.hagag.LoanManagementSystem.entities.Loan;
import com.hagag.LoanManagementSystem.exception.LoanNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachedLoanServices {

    @Autowired
    private LoanRepository loanRepository;

    @Cacheable(value = "loans" , key = "#loanId")
    public Loan getLoanById(Integer loanId) {
        System.out.println("Fetching loan from database for ID: " + loanId);
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFound("Loan not found"));
        return loan;
    }


}
