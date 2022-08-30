package com.pineLabs.PineLabsAssessment.repository;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseOnlineRepository extends JpaRepository<CourseOffline, UUID> {

//    @Modifying
//    @Query("update CourseOffline co set co.courseDate = :courseDate ")
//    void updateCourse();
//
//    @Modifying
//    @Query("update Customer u set u.phone = :phone where u.id = :id")
//    void updatePhone(@Param(value = "id") long id, @Param(value = "phone") String phone);
}
