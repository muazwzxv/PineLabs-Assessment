package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.exception.CourseNotFoundException;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.repository.CourseOnlineRepository;
import com.pineLabs.PineLabsAssessment.service.ICourseOnlineService;
import lombok.AllArgsConstructor;
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

    public void deleteById(UUID uid){
        this.courseOnlineRepository.deleteById(uid);
    }

    public List<CourseOnline> findAllActiveCourses(){
        return this.courseOnlineRepository.getCourseOnlineByStatus(CourseStatus.ACTIVE);
    }
}
