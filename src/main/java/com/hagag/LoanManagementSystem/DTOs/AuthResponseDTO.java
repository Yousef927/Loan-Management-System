package com.hagag.LoanManagementSystem.DTOs;

import com.hagag.LoanManagementSystem.entities.Role;
import lombok.Data;

@Data
public class AuthResponseDTO {

    private String token;
    private String email;
    private Role role;

}
