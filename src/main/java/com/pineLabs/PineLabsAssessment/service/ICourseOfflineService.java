package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;

import java.util.List;
import java.util.UUID;

public interface ICourseOfflineService extends ICrudService<CourseOffline, UUID> {
    List<CourseOffline> findAllActiveCourses();
}
