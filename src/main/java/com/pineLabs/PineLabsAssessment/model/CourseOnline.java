package com.pineLabs.PineLabsAssessment.model;

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
@Table(name = "course_online")
@SQLDelete(sql = "UPDATE course_online SET deleted_on = NOW() WHERE id= ?")
@Where(clause = "deleted_on IS NULL")
public class CourseOnline extends AbstractModel{
    private String courseName;
    private String description;
    private String instructorName;
    @Enumerated(EnumType.STRING)
    private CourseStatus status;
    private String link;
    @Enumerated(EnumType.STRING)
    private CourseCategory category;
    private Integer totalStudent;
    private LocalDate courseDate;
}
