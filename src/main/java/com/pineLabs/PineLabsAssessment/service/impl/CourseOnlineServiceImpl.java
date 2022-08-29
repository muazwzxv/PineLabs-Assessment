package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.exception.CourseNotFoundException;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.repository.CourseOnlineRepository;
import com.pineLabs.PineLabsAssessment.service.ICourseOnlineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseOnlineServiceImpl implements ICourseOnlineService {

    private final CourseOnlineRepository courseOnlineRepository;

    public CourseOnline findById(UUID uid){
        return this.courseOnlineRepository.findById(uid)
                .orElseThrow(() -> {
                    throw new CourseNotFoundException("uuid", uid.toString());
                });
    }

    public List<CourseOnline> findAll(){
        return courseOnlineRepository.findAll();
    }

    public void deleteById(UUID uid){
        this.courseOnlineRepository.deleteById(uid);
    }
}
