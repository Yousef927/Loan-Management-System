package com.hagag.LoanManagementSystem.controllers;

import com.hagag.LoanManagementSystem.DTOs.LoanResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }

//    @PostMapping("/apply")
//    public ResponseEntity<LoanResponseDTO>


}
