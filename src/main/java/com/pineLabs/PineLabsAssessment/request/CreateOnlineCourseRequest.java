package com.pineLabs.PineLabsAssessment.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateOnlineCourseRequest {
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

    @JsonProperty("link")
    @NotBlank
    private String link;

    @JsonProperty("total_student")
    @NotBlank
    private Integer totalStudent;
}
