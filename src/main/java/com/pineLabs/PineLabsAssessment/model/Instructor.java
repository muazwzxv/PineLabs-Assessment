package com.pineLabs.PineLabsAssessment.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructor")
@SQLDelete(sql = "UPDATE instructor SET deleted_on = NOW(), status = 4 WHERE id= ?")
@Where(clause = "deleted_on IS NULL")
public class Instructor extends AbstractModel {
    private String instructorName;
    private String email;
    private String officeRoom;
    private String employeeId;
}
