package com.hagag.LoanManagementSystem.services;

import com.hagag.LoanManagementSystem.DTOs.LoanRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.LoanResponseDTO;
import com.hagag.LoanManagementSystem.daos.LoanRepository;
import com.hagag.LoanManagementSystem.daos.UserRepository;
import com.hagag.LoanManagementSystem.entities.Loan;
import com.hagag.LoanManagementSystem.entities.Role;
import com.hagag.LoanManagementSystem.entities.Status;
import com.hagag.LoanManagementSystem.entities.User;
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

    public ResponseEntity<String> approveLoan(Integer loanId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User user = userRepository.findByEmail(email);
        if(user == null ) {
            throw new RuntimeException("User not found");
        }
        if(user.getRole() != Role.LOAN_OFFICER) {
            return new ResponseEntity<>("Unauthorized" , HttpStatus.FORBIDDEN);
        }

        Loan loan = loanRepository.findById(loanId).orElse(null);
        if(loan == null) {
            throw new RuntimeException("Loan not found");
        }
        if(loan.getStatus() != Status.PENDING) {
            throw new RuntimeException("Loan is not pending");
        }
        loan.setStatus(Status.APPROVED);
        Loan savedLoan = loanRepository.save(loan);

        return new ResponseEntity<>("Loan approved successfully" , HttpStatus.OK);

    }

    public ResponseEntity<String> rejectLoan(Integer loanId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        User user = userRepository.findByEmail(email);
        if(user == null ) {
            throw new RuntimeException("User not found");
        }
        if(user.getRole() != Role.LOAN_OFFICER) {
            return new ResponseEntity<>("Unauthorized" , HttpStatus.FORBIDDEN);
        }

        Loan loan = loanRepository.findById(loanId).orElse(null);
        if(loan == null) {
            throw new RuntimeException("Loan not found");
        }
        if(loan.getStatus() != Status.PENDING) {
            throw new RuntimeException("Loan is not pending");
        }
        loan.setStatus(Status.REJECTED);
        Loan savedLoan = loanRepository.save(loan);

        return new ResponseEntity<>("Loan rejected successfully" , HttpStatus.OK);

    }

    public ResponseEntity<List<LoanResponseDTO>> getMyLoans() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        List<Loan> loans = loanRepository.findByUser(user);
        List<LoanResponseDTO> responseDTO = new ArrayList<>();
        for (Loan loan : loans) {
            LoanResponseDTO dto = LoanResponseDTO.buildResponseFromLoan(loan);
            responseDTO.add(dto);
        }
        return new ResponseEntity<>(responseDTO , HttpStatus.OK);
    }

    public ResponseEntity<LoanResponseDTO> getLoan(Integer loanId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Optional<Loan> loans = loanRepository.findById(loanId);
        if (loans.isEmpty()) {
            throw new RuntimeException("Loan not found");
        }
        Loan loan = loans.get();
        if (user.getRole() == Role.USER)
            if (loan.getUser().getId() != user.getId()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            }
        LoanResponseDTO loanResponseDTO = LoanResponseDTO.buildResponseFromLoan(loan);
        return new ResponseEntity<>(loanResponseDTO , HttpStatus.OK);

    }
}
