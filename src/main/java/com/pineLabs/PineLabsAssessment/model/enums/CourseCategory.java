package com.pineLabs.PineLabsAssessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CourseCategory {
    ART(1),
    SCIENCE(2),
    MATHEMATICS(3),
    PHOTOGRAPHY(4),
    MOTIVATION(5);

    private int code;

    public static String getName(int code) {
        String name = "";
        for (CourseCategory category : CourseCategory.values()) {
            if (category.getCode() == code) {
                name = category.toString();
                break;
            }
        }
        return name;
    }
}
