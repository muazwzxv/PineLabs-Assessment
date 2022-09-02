package com.pineLabs.PineLabsAssessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CourseStatus {
    ACTIVE(1),
    ARCHIVED(2),
    PENDING(3);

    private int code;

    public static String getName(int code) {
        String name = "";
        for (CourseStatus status : CourseStatus.values()) {
            if (status.getCode() == code) {
                name = status.toString();
                break;
            }
        }
        return name;
    }
}
