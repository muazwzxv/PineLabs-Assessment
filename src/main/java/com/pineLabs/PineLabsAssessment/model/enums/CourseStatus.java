package com.pineLabs.PineLabsAssessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum CourseStatus {
    ACTIVE(1),
    ARCHIVED(2),
    PENDING(3),

    DELETED(4);

    private Integer code;

    public static String getName(Integer code) {
        String name = "";
        for (CourseStatus status : CourseStatus.values()) {
            if (Objects.equals(status.getCode(), code)) {
                name = status.toString();
                break;
            }
        }
        return name;
    }
}
