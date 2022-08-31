package com.pineLabs.PineLabsAssessment.repository;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseOnlineRepository extends JpaRepository<CourseOnline, UUID> {
    List<CourseOnline> getCourseOnlineByStatus(CourseStatus status);
}
