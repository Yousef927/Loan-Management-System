package com.hagag.LoanManagementSystem.services;

import com.hagag.LoanManagementSystem.DTOs.LoanRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.LoanResponseDTO;
import com.hagag.LoanManagementSystem.daos.LoanRepository;
import com.hagag.LoanManagementSystem.daos.UserRepository;
import com.hagag.LoanManagementSystem.entities.Loan;
import com.hagag.LoanManagementSystem.entities.Role;
import com.hagag.LoanManagementSystem.entities.Status;
import com.hagag.LoanManagementSystem.entities.User;
import com.hagag.LoanManagementSystem.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LoanRepository loanRepository;


    public ResponseEntity<LoanResponseDTO> applyLoan(LoanRequestDTO loanRequestDTO) {
        User user = getCurrentUser();

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

    public ResponseEntity<String> approveLoan(Integer loanId) {
        User user = getCurrentUser();

        if(user.getRole() != Role.LOAN_OFFICER) {
            throw new Unauthorized("Unauthorized Access");
        }

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFound("Loan not found"));

        if(loan.getStatus() != Status.PENDING) {
            throw new LoanAlreadyApproved("Loan is Already " + loan.getStatus());
        }
        loan.setStatus(Status.APPROVED);
        Loan savedLoan = loanRepository.save(loan);

        return ResponseEntity.ok("Loan approved successfully");

    }

    public ResponseEntity<String> rejectLoan(Integer loanId) {
        User user = getCurrentUser();

        if(user.getRole() != Role.LOAN_OFFICER) {
            throw new Unauthorized("Unauthorized Access");
        }

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFound("Loan not found"));

        if(loan.getStatus() != Status.PENDING) {
            throw new LoanAlreadyRejected("Loan is Already " + loan.getStatus());
        }
        loan.setStatus(Status.REJECTED);
        Loan savedLoan = loanRepository.save(loan);

        return ResponseEntity.ok("Loan rejected successfully");

    }

    public ResponseEntity<List<LoanResponseDTO>> getMyLoans(String status) {
        User user = getCurrentUser();

        List<LoanResponseDTO> responseDTO = new ArrayList<>();

        if(status == null || status.isBlank()) {
            List<Loan> loans = loanRepository.findByUser(user);
            for (Loan loan : loans) {
                LoanResponseDTO dto = LoanResponseDTO.buildResponseFromLoan(loan);
                responseDTO.add(dto);
            }
            return ResponseEntity.ok(responseDTO);
        }
        Status statusEnum;
        try {
            statusEnum = Status.valueOf(status.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new InvalidInput("Invalid status. Allowed values: PENDING, APPROVED, REJECTED");
        }

        List<Loan> loans = loanRepository.findByUserAndStatus(user , statusEnum);

        for(Loan loan : loans) {
            LoanResponseDTO dto = LoanResponseDTO.buildResponseFromLoan(loan);
            responseDTO.add(dto);
        }
        return ResponseEntity.ok(responseDTO);
    }

    public ResponseEntity<LoanResponseDTO> getLoan(Integer loanId) {
        User user = getCurrentUser();

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new LoanNotFound("Loan not found"));

        if (user.getRole() == Role.USER)
            if (loan.getUser().getId() != user.getId()) {
                throw new Unauthorized("Unauthorized Access");
            }
        LoanResponseDTO loanResponseDTO = LoanResponseDTO.buildResponseFromLoan(loan);
        return ResponseEntity.ok(loanResponseDTO);
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userRepository.findByEmail(email);
        if (user == null ) {
            throw new UserNotFound("User not found");
        }
        return user;
    }

}
