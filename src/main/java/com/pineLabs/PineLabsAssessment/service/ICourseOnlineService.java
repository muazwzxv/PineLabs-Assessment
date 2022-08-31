package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.request.CreateOnlineCourseRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICourseOnlineService extends IService<CourseOnline, UUID> {
    List<CourseOnline> findAllActiveCourses();

    CourseOnline create(CreateOnlineCourseRequest request);

    CourseOnline updateById(UUID uid, CreateOnlineCourseRequest req);

//    Optional<CourseOnline> updateById(CourseOnline updatedCourse, UUID uuid);

}
