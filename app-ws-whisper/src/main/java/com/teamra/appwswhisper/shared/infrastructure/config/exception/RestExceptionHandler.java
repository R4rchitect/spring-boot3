package com.teamra.appwswhisper.shared.infrastructure.config.exception;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.teamra.appwswhisper.shared.domain.ApiErrorResponse;
import com.teamra.appwswhisper.shared.domain.ApplicationException;
import com.teamra.appwswhisper.users.domain.exception.UserNotFoundException;

import ch.qos.logback.core.spi.ErrorCodes;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> handleApplicationException(final ApplicationException exception, final HttpServletRequest request) {
        var guid = UUID.randomUUID().toString();
        log.error(
        String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), 
            exception
        );
        var response = new ApiErrorResponse(
                guid,
                exception.getErrorCode(),
                exception.getMessage(),
                exception.getHttpStatus().value(),
                exception.getHttpStatus().name(),
                request.getRequestURI(),
                request.getMethod(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, exception.getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnknownException(final Exception exception, final HttpServletRequest request) {
        var guid = UUID.randomUUID().toString();
        log.error(
            String.format("Error GUID=%s; error message: %s", guid, exception.getMessage()), 
            exception
        );
        var response = new ApiErrorResponse(
                guid,
                "505",
                "Internal server error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                request.getRequestURI(),
                request.getMethod(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
