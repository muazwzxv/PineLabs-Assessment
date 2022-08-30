package com.pineLabs.PineLabsAssessment.model;


import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseOffline extends AbstractModel {
    private String courseName;
    private String description;
    private String instructorName;

    @Enumerated(EnumType.STRING)
    private CourseCategory category;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    private LocalDate courseDate;

    private String venue;
    private Integer totalStudent;
}


