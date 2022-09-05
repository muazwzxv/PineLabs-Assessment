package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.dto.CreateOfflineCourseRequest;

import java.util.List;

public interface ICourseOfflineService extends IService<CourseOffline, Long> {
    List<CourseOffline> findAllActiveCourses();

    CourseOffline create(CreateOfflineCourseRequest req);

    CourseOffline updateById(Long id, CreateOfflineCourseRequest req);

    void updateByIdJpa(Long id, CreateOfflineCourseRequest req);
}
