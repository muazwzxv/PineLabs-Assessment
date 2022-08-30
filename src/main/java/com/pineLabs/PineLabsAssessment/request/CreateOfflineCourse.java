package com.pineLabs.PineLabsAssessment.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import lombok.Getter;

@Getter
public class CreateOfflineCourse {
    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("instructor_name")
    private String instructorName;

    @JsonProperty("category")
    private CourseCategory category;

    @JsonProperty("category")
    private String venue;

    @JsonProperty("total_student")
    private Integer totalStudent;
}
