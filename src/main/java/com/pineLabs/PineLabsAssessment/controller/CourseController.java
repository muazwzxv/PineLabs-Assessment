package com.pineLabs.PineLabsAssessment.controller;

import com.pineLabs.PineLabsAssessment.exception.InvalidParameterException;
import com.pineLabs.PineLabsAssessment.request.CreateOfflineCourseRequest;
import com.pineLabs.PineLabsAssessment.request.CreateOnlineCourseRequest;
import com.pineLabs.PineLabsAssessment.service.ICourseOfflineService;
import com.pineLabs.PineLabsAssessment.service.ICourseOnlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/courses")
@AllArgsConstructor
public class CourseController {

    private final ICourseOfflineService courseOfflineService;
    private final ICourseOnlineService courseOnlineService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.findAllActiveCourses(), HttpStatus.OK);
            case "online":
                return new ResponseEntity<>(this.courseOnlineService.findAllActiveCourses(), HttpStatus.OK);
            default:
                throw new InvalidParameterException();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.findById(id), HttpStatus.OK);
            case "online":
                return new ResponseEntity<>(this.courseOnlineService.findById(id), HttpStatus.OK);
            default:
                throw new InvalidParameterException();
        }
    }

    @PostMapping("/offline")
    public ResponseEntity<?> createOffline(@RequestBody @Valid CreateOfflineCourseRequest request) {
        return new ResponseEntity<>(this.courseOfflineService.create(request), HttpStatus.CREATED);
    }

    @PostMapping("/online")
    public ResponseEntity<?> createOnline(@RequestBody @Valid CreateOnlineCourseRequest onlineRequest) {
        return new ResponseEntity<>(this.courseOnlineService.create(onlineRequest), HttpStatus.CREATED);
    }

    @PutMapping("/offline/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") Long id, @RequestBody @Valid CreateOfflineCourseRequest request) {
        return new ResponseEntity<>(this.courseOfflineService.updateById(id, request), HttpStatus.ACCEPTED);
    }

    @PutMapping("/online/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") Long id, @RequestBody @Valid CreateOnlineCourseRequest onlineRequest) {
        return new ResponseEntity<>(this.courseOnlineService.updateById(id, onlineRequest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.deleteById(id), HttpStatus.ACCEPTED);
            case "online":
                return new ResponseEntity<>(this.courseOnlineService.deleteById(id), HttpStatus.ACCEPTED);
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }
}
