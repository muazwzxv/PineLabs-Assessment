package com.pineLabs.PineLabsAssessment.service;

import com.pineLabs.PineLabsAssessment.model.AbstractModel;

import java.util.List;

public interface CrudService <T, ID>{
    T findById(ID uid);
    List<T> findAll();
    T deleteById(ID uid);
}
