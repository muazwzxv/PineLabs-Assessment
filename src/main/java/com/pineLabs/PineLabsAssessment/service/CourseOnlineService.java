package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.dto.CreateOnlineCourseRequest;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;

import java.util.List;

public interface CourseOnlineService extends IService<CourseOnline, Long> {
    List<CourseOnline> findAllActiveCourses();

    CourseOnline create(CreateOnlineCourseRequest req);

    CourseOnline updateById(Long id, CreateOnlineCourseRequest req);

//    Optional<CourseOnline> updateById(CourseOnline updatedCourse, UUID uuid);

}
