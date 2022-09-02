package com.pineLabs.PineLabsAssessment.repository;

import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseOnlineRepository extends JpaRepository<CourseOnline, Long> {
    List<CourseOnline> getCourseOnlineByStatus(int status);
}
