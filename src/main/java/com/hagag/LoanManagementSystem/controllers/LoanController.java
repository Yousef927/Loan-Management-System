package com.hagag.LoanManagementSystem.controllers;

import com.hagag.LoanManagementSystem.DTOs.LoanRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.LoanResponseDTO;
import com.hagag.LoanManagementSystem.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    LoanServices loanServices;

    @PostMapping("/apply")
    public ResponseEntity<LoanResponseDTO> applyLoan(@RequestBody LoanRequestDTO loanRequestDTO) {

        return loanServices.applyLoan(loanRequestDTO);

    }


}
