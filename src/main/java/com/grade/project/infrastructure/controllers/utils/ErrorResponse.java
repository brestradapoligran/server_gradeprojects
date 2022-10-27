package com.grade.project.infrastructure.controllers.utils;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse {

    private String message;
    private HttpStatus httpStatus;
    private int statusCode;
    private Date timestamp;

    public ErrorResponse(String message, HttpStatus httpStatus, int statusCode, Date timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
