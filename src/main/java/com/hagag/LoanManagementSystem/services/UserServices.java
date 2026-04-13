package com.hagag.LoanManagementSystem.services;

import com.hagag.LoanManagementSystem.DTOs.UserRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.UserResponseDTO;
import com.hagag.LoanManagementSystem.daos.UserRepository;
import com.hagag.LoanManagementSystem.entities.Role;
import com.hagag.LoanManagementSystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    public ResponseEntity<UserResponseDTO> registerUser(UserRequestDTO userRequest) {
        User newUser = new User();

        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(encoder.encode(userRequest.getPassword()));
        newUser.setRole(Role.USER);

        userRepository.save(newUser);

        UserResponseDTO responseDTO = UserResponseDTO.buildResponseFromUser(newUser);

        return new ResponseEntity<>(responseDTO , HttpStatus.CREATED);


    }
}
