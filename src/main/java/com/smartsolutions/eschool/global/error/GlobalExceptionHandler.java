package com.smartsolutions.eschool.global.error;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ApiException.class)
        public ResponseEntity<ErrorResponse> handleApiException(
                        ApiException ex,
                        HttpServletRequest request) {
                log.error("API Exception: {} - {}", ex.getError().code(), ex.getMessage());
                return ResponseEntity
                                .status(ex.getStatus())
                                .body(new ErrorResponse(
                                                ex.getError(),
                                                ex.getMessage(),
                                                request.getRequestURI()));
        }

        @ExceptionHandler(com.smartsolutions.eschool.global.exception.ResourceNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
                        com.smartsolutions.eschool.global.exception.ResourceNotFoundException ex,
                        HttpServletRequest request) {
                log.error("Resource Not Found: {}", ex.getMessage());
                return ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .body(new ErrorResponse(CommonErrors.RESOURCE_NOT_FOUND, request.getRequestURI()));
        }

        @ExceptionHandler(org.springframework.dao.DataAccessException.class)
        public ResponseEntity<ErrorResponse> handleDataAccessException(
                        org.springframework.dao.DataAccessException ex,
                        HttpServletRequest request) {
                log.error("Database Error: {}", ex.getMessage(), ex);
                return ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(new ErrorResponse(CommonErrors.DATABASE_ERROR, request.getRequestURI()));
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleGenericException(
                        Exception ex,
                        HttpServletRequest request) {
                log.error("Unexpected Error: {}", ex.getMessage(), ex);
                return ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(new ErrorResponse(CommonErrors.INTERNAL_SERVER_ERROR, request.getRequestURI()));
        }
}
