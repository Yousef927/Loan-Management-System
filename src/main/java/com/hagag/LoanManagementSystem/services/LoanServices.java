package com.hagag.LoanManagementSystem.services;

import com.hagag.LoanManagementSystem.DTOs.LoanRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.LoanResponseDTO;
import com.hagag.LoanManagementSystem.daos.LoanRepository;
import com.hagag.LoanManagementSystem.daos.UserRepository;
import com.hagag.LoanManagementSystem.entities.Loan;
import com.hagag.LoanManagementSystem.entities.Status;
import com.hagag.LoanManagementSystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoanServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;


    public ResponseEntity<LoanResponseDTO> applyLoan(LoanRequestDTO loanRequestDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User user = userRepository.findByEmail(email);

        Loan loan = new Loan();
        loan.setAmount(loanRequestDTO.getAmount());
        loan.setDurationMonths(loanRequestDTO.getDurationMonths());
        loan.setStatus(Status.PENDING);
        loan.setCreatedAt(LocalDateTime.now());
        loan.setUser(user);

        loanRepository.save(loan);

        LoanResponseDTO responseDTO = LoanResponseDTO.buildResponseFromLoan(loan);

        return new ResponseEntity<>(responseDTO , HttpStatus.CREATED);
    }
}
