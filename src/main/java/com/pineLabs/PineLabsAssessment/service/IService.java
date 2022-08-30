package com.pineLabs.PineLabsAssessment.service;

import java.util.List;

public interface IService<T, ID> {
    T findById(ID uid);

    List<T> findAll();

    T deleteById(ID uid);
}
