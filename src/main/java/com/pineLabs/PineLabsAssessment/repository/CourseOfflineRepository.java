package com.pineLabs.PineLabsAssessment.repository;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface CourseOfflineRepository extends JpaRepository<CourseOffline, UUID> {

    List<CourseOffline> getCourseOfflineByStatus(CourseStatus status);

    @Modifying
    @Query(
            "update CourseOffline as co " +
                    "set co.courseName = :courseName, " +
                    "co.category = :courseCategory, " +
                    "co.description = :description," +
                    "co.venue = :venue," +
                    "co.courseDate = :courseDate," +
                    "co.instructorName = :instructorName," +
                    "co.totalStudent = :totalStudent " +
                    "where co.id = :uid"

    )
    void updateCourse(
            @Param(value = "courseName") String courseName,
            @Param(value = "courseCategory") CourseCategory courseCategory,
            @Param(value = "description") String description,
            @Param(value = "venue") String venue,
            @Param(value = "courseDate") LocalDate courseDate,
            @Param(value = "instructorName") String instructorName,
            @Param(value = "totalStudent") Integer totalStudent,

            // id
            @Param(value = "uid") UUID uid
    );
}
