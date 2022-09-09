package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.dto.CreateInstructor;
import com.pineLabs.PineLabsAssessment.model.Instructor;

public interface InstructorService extends IService<Instructor, Long> {
    Instructor create(CreateInstructor dto);
}
