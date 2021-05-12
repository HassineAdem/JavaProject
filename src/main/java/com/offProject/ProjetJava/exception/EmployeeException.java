package com.offProject.ProjetJava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeException extends RuntimeException {
    public EmployeeException() {
        super();
    }

    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(String message, Throwable cause) {
        super(message, cause);
    }


}
