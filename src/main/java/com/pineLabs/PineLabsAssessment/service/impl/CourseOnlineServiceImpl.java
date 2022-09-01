package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.exception.CourseNotFoundException;
import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.repository.CourseOnlineRepository;
import com.pineLabs.PineLabsAssessment.request.CreateOnlineCourseRequest;
import com.pineLabs.PineLabsAssessment.service.ICourseOnlineService;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseOnlineServiceImpl implements ICourseOnlineService {

    private final CourseOnlineRepository courseOnlineRepository;

    public CourseOnline findById(UUID uid) throws CourseNotFoundException{
        Optional<CourseOnline> course = this.courseOnlineRepository.findById(uid);
        if(!course.isPresent())
            throw new CourseNotFoundException("UUID", uid.toString());
        return course.get();
    }

    public List<CourseOnline> findAll(){
        return this.courseOnlineRepository.findAll();
    }

    @Override
    public CourseOnline deleteById(UUID uid) {
        Optional<CourseOnline> courseOnline = this.courseOnlineRepository.findById(uid);
        if (!courseOnline.isPresent())
            throw new CourseNotFoundException("UUID", uid);

        try {
            this.courseOnlineRepository.deleteById(uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return courseOnline.get();
    }

    public List<CourseOnline> findAllActiveCourses(){
        return this.courseOnlineRepository.getCourseOnlineByStatus(CourseStatus.ACTIVE);
    }

    public CourseOnline create(CreateOnlineCourseRequest requests){
        CourseOnline course = CourseOnline.builder()
                .courseName(requests.getCourseName())
                .category(requests.getCategory())
                .status(CourseStatus.PENDING)
                .description(requests.getDescription())
                .link(requests.getLink())
                .instructorName(requests.getInstructorName())
                .totalStudent(requests.getTotalStudent())
                .courseDate(requests.getCourseDate())
                .build();
        return this.courseOnlineRepository.save(course);
    }

    public CourseOnline updateById(UUID uid, CreateOnlineCourseRequest request){
        Optional<CourseOnline> course = this.courseOnlineRepository.findById(uid);
        if (!course.isPresent())
            throw new CourseNotFoundException("UUID", uid.toString());

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
