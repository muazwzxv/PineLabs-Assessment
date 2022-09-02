package com.pineLabs.PineLabsAssessment.model;


import com.fasterxml.jackson.annotation.JsonProperty;
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
@SQLDelete(sql = "UPDATE course_offline SET deleted_on = NOW(), status = 4 WHERE id= ?")
@Where(clause = "deleted_on IS NULL")
public class CourseOffline extends AbstractModel {
    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("instructor_name")
    private String instructorName;

    @JsonProperty("category")
    private Integer category;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("course_date")
    private LocalDate courseDate;

    @JsonProperty("venue")
    private String venue;

    @JsonProperty("total_student")
    private Integer totalStudent;
}


