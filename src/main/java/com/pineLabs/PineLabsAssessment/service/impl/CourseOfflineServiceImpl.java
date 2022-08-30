package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.exception.CourseNotFoundException;
import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.repository.CourseOfflineRepository;
import com.pineLabs.PineLabsAssessment.request.CreateOfflineCourseRequest;
import com.pineLabs.PineLabsAssessment.service.ICourseOfflineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseOfflineServiceImpl implements ICourseOfflineService {
    private final CourseOfflineRepository courseOfflineRepository;

    @Override
    public CourseOffline findById(UUID uid) throws CourseNotFoundException {
        Optional<CourseOffline> course = this.courseOfflineRepository.findById(uid);
        if (!course.isPresent())
            throw new CourseNotFoundException("UUID", uid.toString());

        return course.get();
    }

    @Override
    public List<CourseOffline> findAll() {
        return this.courseOfflineRepository.findAll();
    }

    @Override
    public Optional<CourseOnline> deleteById(UUID uid) {
        this.courseOfflineRepository.deleteById(uid);
        return null;
    }

    @Override
    public List<CourseOffline> findAllActiveCourses() {
        return this.courseOfflineRepository.getCourseOfflineByStatus(CourseStatus.ACTIVE);
    }

    @Override
    public CourseOffline create(CreateOfflineCourseRequest request) {
        CourseOffline course = CourseOffline.builder()
                .courseName(request.getCourseName())
                .category(request.getCategory())
                .status(CourseStatus.PENDING)
                .description(request.getDescription())
                .venue(request.getVenue())
                .instructorName(request.getInstructorName())
                .totalStudent(request.getTotalStudent())
                .build();

        return this.courseOfflineRepository.save(course);
    }
}
