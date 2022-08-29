package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.model.CourseOnline;

import java.util.List;
import java.util.UUID;

public interface ICourseOnlineService extends ICrudService<CourseOnline, UUID> {
    List<CourseOnline> findAllActiveCourses();
}
