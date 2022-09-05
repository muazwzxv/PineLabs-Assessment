package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.dto.CreateOnlineCourseRequest;

import java.util.List;

public interface ICourseOnlineService extends IService<CourseOnline, Long> {
    List<CourseOnline> findAllActiveCourses();

    CourseOnline create(CreateOnlineCourseRequest req);

    CourseOnline updateById(Long id, CreateOnlineCourseRequest req);

//    Optional<CourseOnline> updateById(CourseOnline updatedCourse, UUID uuid);

}
