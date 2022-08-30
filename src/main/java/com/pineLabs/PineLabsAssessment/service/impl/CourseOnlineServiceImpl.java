package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.exception.CourseNotFoundException;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.repository.CourseOnlineRepository;
import com.pineLabs.PineLabsAssessment.request.CreateOnlineCourseRequest;
import com.pineLabs.PineLabsAssessment.service.ICourseOnlineService;
import lombok.AllArgsConstructor;
import lombok.var;
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

    public Optional<CourseOnline> deleteById(UUID uid){

        var deleteCourse = this.courseOnlineRepository.findById(uid);
        this.courseOnlineRepository.deleteById(uid);
        return deleteCourse;
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
                .total_student(requests.getTotalStudent())
                .build();
        return this.courseOnlineRepository.save(course);
    }

    public Optional<CourseOnline> updateById(CourseOnline updatedCourse, UUID uuid){
        return this.courseOnlineRepository.findById(uuid)
                .map(courseOnline -> {
                    courseOnline.setCourseName(updatedCourse.getCourseName());
                    courseOnline.setCategory(updatedCourse.getCategory());
                    courseOnline.setStatus(updatedCourse.getStatus());
                    courseOnline.setDescription(updatedCourse.getDescription());
                    courseOnline.setLink(updatedCourse.getLink());
                    courseOnline.setInstructorName(updatedCourse.getInstructorName());
                    courseOnline.setTotal_student(updatedCourse.getTotal_student());

                    return this.courseOnlineRepository.save(courseOnline);

                });
    }
}
