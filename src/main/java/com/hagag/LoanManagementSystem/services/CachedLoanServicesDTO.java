package com.hagag.LoanManagementSystem.services;

import com.hagag.LoanManagementSystem.DTOs.LoanHistoryResponseDTO;
import com.hagag.LoanManagementSystem.daos.LoanHistoryRepository;
import com.hagag.LoanManagementSystem.entities.LoanHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CachedLoanServicesDTO {



    @Autowired
    LoanHistoryRepository loanHistoryRepository;

    @Cacheable(value = "loanHistory" , key = "#loanId")
    public List<LoanHistoryResponseDTO> getCachedLoanDTO(Integer loanId) {
        System.out.println("Fetching loan history from database for loanId: " + loanId);
        List<LoanHistoryResponseDTO> responseDTO = new ArrayList<>();
        List<LoanHistory> loanHistories = loanHistoryRepository.findByLoanId(loanId);
        for (LoanHistory loanHistory : loanHistories) {
            LoanHistoryResponseDTO dto = LoanHistoryResponseDTO.buildResponseFromHistory(loanHistory);
            responseDTO.add(dto);
        }
        return responseDTO;
    }


}
