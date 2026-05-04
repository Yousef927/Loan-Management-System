package com.hagag.LoanManagementSystem.controllers;


import com.hagag.LoanManagementSystem.DTOs.UserRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.UserResponseDTO;
import com.hagag.LoanManagementSystem.entities.User;
import com.hagag.LoanManagementSystem.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO user) {
        return userServices.registerUser(user);
    }

    @PostMapping("/register-officer")
    public ResponseEntity<UserResponseDTO> registerOfficer(@RequestBody UserRequestDTO user) {
        return userServices.registerOfficer(user);
    }
}
