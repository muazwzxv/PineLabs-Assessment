package com.pineLabs.PineLabsAssessment.model;

import lombok.*;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseOnline extends AbstractModel{
    private String courseName;
    private String instructorName;
    private String url;
    private String status;
}
