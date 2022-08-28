package com.pineLabs.PineLabsAssessment.repository;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseOnlineRepository extends JpaRepository<CourseOffline, UUID> {
}
