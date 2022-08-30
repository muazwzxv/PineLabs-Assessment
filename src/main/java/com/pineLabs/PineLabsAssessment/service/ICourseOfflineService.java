package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.request.CreateOfflineCourseRequest;

import java.util.List;
import java.util.UUID;

public interface ICourseOfflineService extends IService<CourseOffline, UUID> {
    List<CourseOffline> findAllActiveCourses();

    CourseOffline create(CreateOfflineCourseRequest request);

    CourseOffline updateById(UUID uid, CreateOfflineCourseRequest req);
}
