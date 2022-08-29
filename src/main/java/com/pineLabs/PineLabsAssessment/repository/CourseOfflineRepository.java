package com.pineLabs.PineLabsAssessment.repository;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CourseOfflineRepository extends JpaRepository<CourseOffline, UUID> {
}
