package com.pineLabs.PineLabsAssessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateInstructor {
    @JsonProperty("instructor_name")
    private String instructorName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("office_room")
    private String officeRoom;

    @JsonProperty("employeeID")
    private String employeeId;
}
