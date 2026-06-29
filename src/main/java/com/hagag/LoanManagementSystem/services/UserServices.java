package com.hagag.LoanManagementSystem.services;

import com.hagag.LoanManagementSystem.DTOs.LoginRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.UserRequestDTO;
import com.hagag.LoanManagementSystem.DTOs.UserResponseDTO;
import com.hagag.LoanManagementSystem.daos.UserRepository;
import com.hagag.LoanManagementSystem.entities.Role;
import com.hagag.LoanManagementSystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;

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

    public ResponseEntity<UserResponseDTO> registerOfficer(UserRequestDTO userRequest) {
        User newUser = new User();

        newUser.setName(userRequest.getName());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(encoder.encode(userRequest.getPassword()));
        newUser.setRole(Role.LOAN_OFFICER);

        userRepository.save(newUser);

        UserResponseDTO responseDTO = UserResponseDTO.buildResponseFromUser(newUser);

        return new ResponseEntity<>(responseDTO , HttpStatus.CREATED);



    }

    public String verifyLogin(LoginRequestDTO loginRequestDTO) {
        String token = null;
        Authentication authentication= authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getEmail(),
                        loginRequestDTO.getPassword()
                )
        );
        if (authentication.isAuthenticated()) {
            token = jwtService.generateToken(loginRequestDTO.getEmail());
        }
        return token;

    }
}
