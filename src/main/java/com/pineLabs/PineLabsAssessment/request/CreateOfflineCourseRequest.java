package com.pineLabs.PineLabsAssessment.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

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
//    @ValueOfEnum(enumClass = CourseCategory.class)
    private int category;

    @JsonProperty("venue")
    @NotBlank
    private String venue;

    @JsonProperty("total_student")
    @Min(value = 0)
    private int totalStudent;

    @JsonProperty("course_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Future
    private LocalDate courseDate;
}
