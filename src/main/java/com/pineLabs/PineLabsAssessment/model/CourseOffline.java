package com.pineLabs.PineLabsAssessment.model;


import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "course_offline")
@SQLDelete(sql = "UPDATE course_offline SET deleted_on = NOW() WHERE id= ?")
@Where(clause = "deleted_on IS NULL")
public class CourseOffline extends AbstractModel {
    private String courseName;
    private String description;
    private String instructorName;

    private int category;

    private CourseStatus status;

    private LocalDate courseDate;

    private String venue;
    private Integer totalStudent;
}


