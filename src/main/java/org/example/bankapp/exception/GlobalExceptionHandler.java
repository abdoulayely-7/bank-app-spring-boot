package org.example.bankapp.exception;

import org.example.bankapp.api.ApiResponse;
import org.example.bankapp.dto.ApiErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

        @Autowired
        private MessageSource messageSource;

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ApiErrorResponse> handleValidationException(
                        MethodArgumentNotValidException ex, HttpServletRequest request) {

                Map<String, String> errors = new HashMap<>();
                ex.getBindingResult().getFieldErrors().forEach(error -> {
                        errors.put(error.getField(), error.getDefaultMessage());
                });

                ApiErrorResponse errorsResponse = new ApiErrorResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                messageSource.getMessage("VALIDATION_FAILED", null, Locale.getDefault()),
                                // errors,
                                request.getRequestURI());

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(errorsResponse);
        }

        @ExceptionHandler(BusinessException.class)
        public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException ex,
                        HttpServletRequest request) {
                ApiErrorResponse error = new ApiErrorResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                ex.getMessage(),
                                request.getRequestURI());
                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(ApiResponse.erroor(error));
        }

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<ApiResponse<Void>> handleInvalidJson(HttpMessageNotReadableException ex,
                        HttpServletRequest request) {
                String msg = messageSource.getMessage("INVALID_JSON", null, Locale.getDefault());
                ApiErrorResponse errorsResponse = new ApiErrorResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                msg,
                                request.getRequestURI());
                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(ApiResponse.erroor(errorsResponse));
        }

}
