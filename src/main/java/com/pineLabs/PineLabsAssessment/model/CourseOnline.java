package com.pineLabs.PineLabsAssessment.model;

import com.pineLabs.PineLabsAssessment.model.enums.Category;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.model.enums.Status;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseOnline extends AbstractModel{
    private String courseName;
    private String description;
    private String instructorName;
    @Enumerated(EnumType.ORDINAL)
    private CourseStatus status;
    private String link;
    @Enumerated(EnumType.ORDINAL)
    private CourseCategory category;
    private Integer total_student;
}
