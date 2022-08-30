package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.model.CourseOnline;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {
    T findById(ID uid);

    List<T> findAll();

    Optional<CourseOnline> deleteById(ID uid);
}
