package com.pineLabs.PineLabsAssessment.helper;

import com.pineLabs.PineLabsAssessment.exception.InvalidParameterException;

import java.util.UUID;

public class Helper {
    public static UUID convertStringToUUID(String uuidString) {
        try {
            return UUID.fromString(uuidString);

        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException();
        }
    }
}
