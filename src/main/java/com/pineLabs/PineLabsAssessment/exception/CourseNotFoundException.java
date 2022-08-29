package com.pineLabs.PineLabsAssessment.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException{
    private final String fieldName;
    private final Object fieldValue;

    public CourseNotFoundException(String fieldName, Object fieldValue) {
        super(String.format("Family not found with %s: '%s'", fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

