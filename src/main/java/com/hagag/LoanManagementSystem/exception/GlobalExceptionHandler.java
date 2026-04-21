package com.hagag.LoanManagementSystem.exception;


import com.hagag.LoanManagementSystem.DTOs.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFound.class , LoanNotFound.class})
    public ResponseEntity<ErrorResponse> handleNotFound(Exception ex) {
        ErrorResponse errorResponse = ErrorResponse.buildErrorResponse(ex.getMessage() , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidInput.class)
    public ResponseEntity<ErrorResponse> handleInvalidInput(InvalidInput ex) {
        ErrorResponse errorResponse = ErrorResponse.buildErrorResponse(ex.getMessage() , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Forbidden.class)
    public ResponseEntity<ErrorResponse> handleUnauthorization(Forbidden ex){
        ErrorResponse errorResponse = ErrorResponse.buildErrorResponse(ex.getMessage(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(errorResponse , HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(LoanAlreadyApproved.class)
    public ResponseEntity<ErrorResponse> handleLoanAlreadyApproved(LoanAlreadyApproved ex) {
        ErrorResponse errorResponse = ErrorResponse.buildErrorResponse(ex.getMessage() , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LoanAlreadyRejected.class)
    public ResponseEntity<ErrorResponse> handleLoanAlreadyRejected(LoanAlreadyRejected ex) {
        ErrorResponse errorResponse = ErrorResponse.buildErrorResponse(ex.getMessage() , HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
}

}
