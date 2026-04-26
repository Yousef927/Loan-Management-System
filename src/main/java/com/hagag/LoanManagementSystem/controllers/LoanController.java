package com.hagag.LoanManagementSystem.controllers;

import com.hagag.LoanManagementSystem.DTOs.LoanHistoryResponseDTO;
import com.hagag.LoanManagementSystem.DTOs.LoanRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.LoanResponseDTO;
import com.hagag.LoanManagementSystem.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
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
    @GetMapping("/myloans")
    public ResponseEntity<List<LoanResponseDTO>> getMyLoans(@RequestParam(required = false) String status) {
        return loanServices.getMyLoans(status);
    }
    @GetMapping("/loan/{loanId}")
    public ResponseEntity<LoanResponseDTO> getLoan(@PathVariable Integer loanId) {
        return loanServices.getLoan(loanId);
    }
    @GetMapping("loan{loanId}/history")
    public ResponseEntity<List<LoanHistoryResponseDTO>> getLoanHistory(@PathVariable Integer loanId) {
        return loanServices.getLoanHistory(loanId);
    }





}
