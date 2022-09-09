package com.pineLabs.PineLabsAssessment.controller;

import com.pineLabs.PineLabsAssessment.dto.CreateInstructor;
import com.pineLabs.PineLabsAssessment.service.InstructorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/instructor")
@AllArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.instructorService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postInstructor(@RequestBody @Valid CreateInstructor dto) {
        return new ResponseEntity<>(this.instructorService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(this.instructorService.findAll(), HttpStatus.OK);
    }
}
