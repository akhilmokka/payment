package com.tms.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PaymentIdNotFoundException.class)
    public ResponseEntity<?> handlePaymentException(PaymentIdNotFoundException ex, WebRequest request) {
        // Create a custom error response object if needed
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
