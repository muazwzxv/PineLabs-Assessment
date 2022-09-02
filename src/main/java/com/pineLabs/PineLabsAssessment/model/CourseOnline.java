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
@Table(name = "course_online")
@SQLDelete(sql = "UPDATE course_online SET deleted_on = NOW(), status = 4 WHERE id= ?")
@Where(clause = "deleted_on IS NULL")
public class CourseOnline extends AbstractModel {

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("instructor_name")
    private String instructorName;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("link")
    private String link;

    @JsonProperty("category")
    private int category;

    @JsonProperty("total_student")
    private Integer totalStudent;

    @JsonProperty("course_date")
    private LocalDate courseDate;
}
