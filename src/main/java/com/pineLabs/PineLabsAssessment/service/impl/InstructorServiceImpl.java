package com.pineLabs.PineLabsAssessment.service.impl;

import com.pineLabs.PineLabsAssessment.dto.CreateInstructor;
import com.pineLabs.PineLabsAssessment.exception.InstructorNotFoundException;
import com.pineLabs.PineLabsAssessment.model.Instructor;
import com.pineLabs.PineLabsAssessment.repository.InstructorRepository;
import com.pineLabs.PineLabsAssessment.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Override
    public Instructor create(CreateInstructor dto) {
        Instructor instructor = Instructor.builder()
                .instructorName(dto.getInstructorName())
                .email(dto.getEmail())
                .officeRoom(dto.getOfficeRoom())
                .employeeId(dto.getEmployeeId())
                .build();

        return this.instructorRepository.save(instructor);
    }

    @Override
    public Instructor findById(Long id) {
        Optional<Instructor> instructor = this.instructorRepository.findById(id);
        if (!instructor.isPresent())
            throw new InstructorNotFoundException("ID", id);

        return instructor.get();
    }

    @Override
    public List<Instructor> findAll() {
        return this.instructorRepository.findAll();
    }

    @Override
    public Instructor deleteById(Long id) {
        Optional<Instructor> instructor = this.instructorRepository.findById(id);
        if (!instructor.isPresent())
            throw new InstructorNotFoundException("ID", id);

        try {
            this.instructorRepository.deleteById(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return instructor.get();
    }
}
