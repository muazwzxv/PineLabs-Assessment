package com.pineLabs.PineLabsAssessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException() {
        super("Invalid parameter");
    }
}
