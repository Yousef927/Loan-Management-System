package com.hagag.LoanManagementSystem.controllers;

import com.hagag.LoanManagementSystem.DTOs.LoanRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.LoanResponseDTO;
import com.hagag.LoanManagementSystem.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanController {

    @Autowired
    LoanServices loanServices;

    @PostMapping("/apply")
    public ResponseEntity<LoanResponseDTO> applyLoan(@RequestBody LoanRequestDTO loanRequestDTO) {

        return loanServices.applyLoan(loanRequestDTO);
    }

    @PostMapping("/approve/{loanId}")
    public ResponseEntity<String> approveLoan(@PathVariable Integer loanId) {
        return loanServices.approveLoan(loanId);
    }

    @PostMapping("/reject/{loanId}")
    public ResponseEntity<String> rejectLoan(@PathVariable Integer loanId) {
        return loanServices.rejectLoan(loanId);
    }



}
