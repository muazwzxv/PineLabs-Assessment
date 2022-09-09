package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.dto.CreateOnlineCourseRequest;
import com.pineLabs.PineLabsAssessment.exception.CourseNotFoundException;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.repository.CourseOnlineRepository;
import com.pineLabs.PineLabsAssessment.service.CourseOnlineService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseOnlineServiceImpl implements CourseOnlineService {

    private final CourseOnlineRepository courseOnlineRepository;

    public CourseOnline findById(Long id) throws CourseNotFoundException {
        Optional<CourseOnline> course = this.courseOnlineRepository.findById(id);
        if (!course.isPresent())
            throw new CourseNotFoundException("ID", id);
        return course.get();
    }

    public List<CourseOnline> findAll() {
        return this.courseOnlineRepository.findAll();
    }

    @Override
    public CourseOnline deleteById(Long id) {
        Optional<CourseOnline> courseOnline = this.courseOnlineRepository.findById(id);
        if (!courseOnline.isPresent())
            throw new CourseNotFoundException("ID", id);

        try {
            this.courseOnlineRepository.deleteById(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return courseOnline.get();
    }

    public List<CourseOnline> findAllActiveCourses() {
        return this.courseOnlineRepository.getCourseOnlineByStatus(CourseStatus.ACTIVE.getCode());
    }

    public CourseOnline create(CreateOnlineCourseRequest requests) {
        CourseOnline course = CourseOnline.builder()
                .courseName(requests.getCourseName())
                .category(requests.getCategory())
                .status(CourseStatus.PENDING.getCode())
                .description(requests.getDescription())
                .link(requests.getLink())
                .instructorName(requests.getInstructorName())
                .totalStudent(requests.getTotalStudent())
                .courseDate(requests.getCourseDate())
                .build();
        return this.courseOnlineRepository.save(course);
    }

    public CourseOnline updateById(Long id, CreateOnlineCourseRequest request) {
        Optional<CourseOnline> course = this.courseOnlineRepository.findById(id);
        if (!course.isPresent())
            throw new CourseNotFoundException("ID", id);

        CourseOnline courseToUpdate = course.get();

        courseToUpdate.setCourseName(request.getCourseName());
        courseToUpdate.setCategory(request.getCategory());
        courseToUpdate.setDescription(request.getDescription());
        courseToUpdate.setLink(request.getLink());
        courseToUpdate.setInstructorName(request.getInstructorName());
        courseToUpdate.setTotalStudent(request.getTotalStudent());
        courseToUpdate.setCourseDate(request.getCourseDate());

        return this.courseOnlineRepository.save(courseToUpdate);
    }
}
