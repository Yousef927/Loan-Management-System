package com.hagag.LoanManagementSystem.controllers;

import com.hagag.LoanManagementSystem.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;




@SpringBootTest
@AutoConfigureMockMvc
public class LoanControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JwtService jwtService;

    Integer loanId = 7;


    String jsonRequest = """
            {
                "amount": 10020,
                "term": 18
            }
            """;


    @Test
    void applyForLoanTest() throws Exception {

        String token = getTokenForUser();

        mockMvc.perform(
                post("/api/loans/apply")
                        .header("Authorization", "Bearer "+ token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        )
                .andExpect(status().is4xxClientError());
    }

    @Test
    void approveLoanTest() throws Exception {

        String token = getTokenForOfficer();

        mockMvc.perform(
                post("/api/loans/approve/" + loanId)
                        .header("Authorization", "Bearer "+ token)

        )
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    void rejectLoanTest() throws  Exception {

        String token = getTokenForOfficer();

        mockMvc.perform(
                post("/api/loans/reject/" + loanId)
                        .header("Authorization", "Bearer "+ token)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getMyLoansTest() throws Exception {

        String token = getTokenForUser();

        mockMvc.perform(
                get("/api/loans/myloans")
                        .header("Authorization", "Bearer "+ token)
                        .param("status" , "APPROVED")
                        .param("page" , "0")
                        .param("size" , "5")
                        .param("sortBy" , "createdAt")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getLoanTest() throws Exception {

        String token = getTokenForUser();

        mockMvc.perform(
                get("/api/loans/loan/" + loanId)
                        .header("Authorization", "Bearer " + token)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getLoanHistoryTest() throws Exception {

        String token = getTokenForUser();

        mockMvc.perform(
                get("/api/loans/loan/" + loanId + "/history")
                        .header("Authorization" , "Bearer " + token)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    String getTokenForUser() {
        String token = jwtService.generateToken("anasahmed927@gmail.com");
        return token;
    }
    String getTokenForOfficer() {
        String token = jwtService.generateToken("officer927@gmail.com");
        return token;
    }
}
