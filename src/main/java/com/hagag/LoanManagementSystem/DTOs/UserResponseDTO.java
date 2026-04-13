package com.hagag.LoanManagementSystem.DTOs;


import com.hagag.LoanManagementSystem.entities.User;
import lombok.Data;

@Data
public class UserResponseDTO {

    private Integer id;
    private String name;
    private String email;

    public static UserResponseDTO buildResponseFromUser(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        return response;
    }

}


