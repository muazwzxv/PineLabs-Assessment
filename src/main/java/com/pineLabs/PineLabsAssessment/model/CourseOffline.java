package com.pineLabs.PineLabsAssessment.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("instructor_name")
    private String instructorName;

    @JsonProperty("category")
    @Enumerated(EnumType.STRING)
    private CourseCategory category;

    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private CourseStatus status;

    @JsonProperty("course_date")
    private LocalDate courseDate;

    @JsonProperty("venue")
    private String venue;

    @JsonProperty("total_student")
    private Integer totalStudent;
}


