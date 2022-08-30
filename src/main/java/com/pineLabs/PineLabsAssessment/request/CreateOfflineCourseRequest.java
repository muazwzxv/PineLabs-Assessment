package com.pineLabs.PineLabsAssessment.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateOfflineCourseRequest {
    @JsonProperty("course_name")
    @NotBlank
    private String courseName;

    @JsonProperty("description")
    @NotBlank
    private String description;

    @JsonProperty("instructor_name")
    @NotBlank
    private String instructorName;

    @JsonProperty("category")
    @NotBlank
    private CourseCategory category;

    @JsonProperty("category")
    @NotBlank
    private String venue;

    @JsonProperty("total_student")
    @NotBlank
    private Integer totalStudent;
}
