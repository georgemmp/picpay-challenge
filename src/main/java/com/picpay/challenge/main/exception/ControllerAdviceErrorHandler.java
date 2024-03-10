package com.picpay.challenge.main.exception;

import com.picpay.challenge.domain.entity.CustomerError;
import com.picpay.challenge.domain.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdviceErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomerError> notNoundException(NotFoundException e, HttpServletRequest request) {
        CustomerError error = new CustomerError(LocalDateTime.now(), e.getStatusCode(), request.getRequestURI(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<CustomerError> forbiddenException(ForbiddenException e, HttpServletRequest request) {
        CustomerError error = new CustomerError(LocalDateTime.now(), e.getStatusCode(), request.getRequestURI(), e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<CustomerError> unauthorizedException(UnauthorizedException e, HttpServletRequest request) {
        CustomerError error = new CustomerError(LocalDateTime.now(), e.getStatusCode(), request.getRequestURI(), e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<CustomerError> unauthorizedException(InternalServerError e, HttpServletRequest request) {
        CustomerError error = new CustomerError(LocalDateTime.now(), e.getStatusCode(), request.getRequestURI(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(ApiConsumerException.class)
    public ResponseEntity<CustomerError> unauthorizedException(ApiConsumerException e, HttpServletRequest request) {
        CustomerError error = new CustomerError(LocalDateTime.now(), e.getStatusCode(), request.getRequestURI(), e.getMessage());
        return ResponseEntity.status(e.getStatusCode()).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CustomerError> unauthorizedException(BadRequestException e, HttpServletRequest request) {
        CustomerError error = new CustomerError(LocalDateTime.now(), e.getStatusCode(), request.getRequestURI(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
