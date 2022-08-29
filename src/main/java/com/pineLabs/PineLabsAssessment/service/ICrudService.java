package com.pineLabs.PineLabsAssessment.service;

import java.util.List;

public interface ICrudService<T, ID>{
    T findById(ID uid);
    List<T> findAll();
    void deleteById(ID uid);
}
