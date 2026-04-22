package com.hagag.LoanManagementSystem.DTOs;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

}
