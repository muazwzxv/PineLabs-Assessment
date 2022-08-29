package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.exception.CourseNotFoundException;
import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.repository.CourseOfflineRepository;
import com.pineLabs.PineLabsAssessment.service.ICourseOfflineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CourseOfflineServiceImpl implements ICourseOfflineService {
    private final CourseOfflineRepository courseOfflineRepository;

    @Override
    public CourseOffline findById(UUID uid) {
        return this.courseOfflineRepository.findById(uid)
                .orElseThrow(() -> {
                    throw new CourseNotFoundException("uuid", uid.toString());
                });
    }

    @Override
    public List<CourseOffline> findAll() {
        return courseOfflineRepository.findAll();
    }

    @Override
    public void deleteById(UUID uid) {
        this.courseOfflineRepository.deleteById(uid);
    }
}
