package com.hagag.LoanManagementSystem.controllers;

import com.hagag.LoanManagementSystem.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class LoanControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JwtService jwtService;


    String jsonRequest = """
            {
                "amount": 10020,
                "term": 18
            }
            """;


    @Test
    void applyForLoanTest() throws Exception {

        String token = jwtService.generateToken("anasahmed927@gmail.com");

        mockMvc.perform(
                post("/api/loans/apply")
                        .header("Authorization", "Bearer "+ token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        )
                .andExpect(status().is4xxClientError());
    }
}
