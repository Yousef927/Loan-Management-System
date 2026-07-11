package com.hagag.LoanManagementSystem.services;

import com.hagag.LoanManagementSystem.DTOs.LoanHistoryResponseDTO;
import com.hagag.LoanManagementSystem.daos.LoanHistoryRepository;
import com.hagag.LoanManagementSystem.daos.LoanRepository;
import com.hagag.LoanManagementSystem.entities.Loan;
import com.hagag.LoanManagementSystem.entities.LoanHistory;
import com.hagag.LoanManagementSystem.exception.LoanNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CachedLoanServices {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    LoanHistoryRepository loanHistoryRepository;

    @Cacheable(value = "loans" , key = "#loanId")
    public List<LoanHistoryResponseDTO> getCachedLoanDTO(Integer loanId) {
        List<LoanHistoryResponseDTO> responseDTO = new ArrayList<>();
        List<LoanHistory> loanHistories = loanHistoryRepository.findByLoanId(loanId);
        for (LoanHistory loanHistory : loanHistories) {
            LoanHistoryResponseDTO dto = LoanHistoryResponseDTO.buildResponseFromHistory(loanHistory);
            responseDTO.add(dto);
        }
        return responseDTO;
    }


}
