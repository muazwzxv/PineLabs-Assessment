package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.exception.CourseNotFoundException;
import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.repository.CourseOfflineRepository;
import com.pineLabs.PineLabsAssessment.request.CreateOfflineCourseRequest;
import com.pineLabs.PineLabsAssessment.service.ICourseOfflineService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
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
    public CourseOffline deleteById(UUID uid) {
        Optional<CourseOffline> courseOffline = this.courseOfflineRepository.findById(uid);
        if (!courseOffline.isPresent())
            throw new CourseNotFoundException("UUID", uid);

        try {
            this.courseOfflineRepository.deleteById(uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return courseOffline.get();
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

    @Override
    public CourseOffline updateById(UUID uid, CreateOfflineCourseRequest request) {
        Optional<CourseOffline> course = this.courseOfflineRepository.findById(uid);
        if (!course.isPresent())
            throw new CourseNotFoundException("UUID", uid.toString());

        CourseOffline courseToUpdate = course.get();

        courseToUpdate.setCourseName(request.getCourseName());
        courseToUpdate.setCategory(request.getCategory());
        courseToUpdate.setDescription(request.getDescription());
        courseToUpdate.setVenue(request.getVenue());
        courseToUpdate.setCourseDate(request.getCourseDate());
        courseToUpdate.setInstructorName(request.getInstructorName());
        courseToUpdate.setTotalStudent(request.getTotalStudent());


        return this.courseOfflineRepository.save(courseToUpdate);
    }


    @Override
    public void updateByIdJpa(UUID uid, CreateOfflineCourseRequest request) {
        boolean found = this.courseOfflineRepository.existsById(uid);
        if (!found)
            throw new CourseNotFoundException("UUID", uid.toString());

        this.courseOfflineRepository
                .updateCourse(
                        request.getCourseName(),
                        request.getCategory(),
                        request.getDescription(),
                        request.getVenue(),
                        request.getCourseDate(),
                        request.getInstructorName(),
                        request.getTotalStudent(),
                        uid
                );
    }
}
