package com.pineLabs.PineLabsAssessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum CourseCategory {
    ART(1),
    SCIENCE(2),
    MATHEMATICS(3),
    PHOTOGRAPHY(4),
    MOTIVATION(5);

    private Integer code;

    public static String getName(Integer code) {
        String name = "";
        for (CourseCategory category : CourseCategory.values()) {
            if (Objects.equals(category.getCode(), code)) {
                name = category.toString();
                break;
            }
        }
        return name;
    }
}
