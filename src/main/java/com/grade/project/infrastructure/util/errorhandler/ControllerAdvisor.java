package com.grade.project.infrastructure.util.errorhandler;

import com.grade.project.domain.exceptions.BadDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(BadDataException.class)
    public ResponseEntity<ErrorResponse> handleBadDataException(BadDataException exception) {
        ErrorResponse error = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, 400, new Date());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }
}
