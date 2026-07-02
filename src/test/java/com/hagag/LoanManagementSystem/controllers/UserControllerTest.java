package com.hagag.LoanManagementSystem.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    String jsonRequest = """
            {
                "name": "Yousef",
                "email": "Yousef@gmai.com",
                "password": "12345"
            }
            """;
    String jsonLoginRequest = """
            {
               "email" : "anasahmed927@gmail.com",
               "password" : "12345"
            }
            """;

    @Test
    void registerUserTest() throws Exception {
            mockMvc.perform(
                    post("/api/users/register")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonRequest)
            )
                    .andDo(print());

    }

    @Test
    void loginUserTest() throws Exception {
        mockMvc.perform(
                post("/api/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonLoginRequest)
        )
                .andDo(print())
                .andExpect(status().isOk());;
    }



}
