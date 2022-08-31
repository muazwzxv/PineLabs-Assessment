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
import java.util.UUID;

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
                throw new RuntimeException("Invalid arguments");
        }
    }

    @GetMapping("/{uid}")
    public ResponseEntity<?> getById(@PathVariable("uid") String uid, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.findById(UUID.fromString(uid)), HttpStatus.OK);
            case "online":
                return new ResponseEntity<>(this.courseOnlineService.findById(UUID.fromString(uid)), HttpStatus.OK);
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

    @PutMapping("/offline/{uid}")
    public ResponseEntity<?> updateById(@PathVariable("uid") String uid, @RequestBody @Valid CreateOfflineCourseRequest request) {
        return new ResponseEntity<>(this.courseOfflineService.updateById(UUID.fromString(uid), request), HttpStatus.ACCEPTED);
    }

    @PutMapping("/online/{uid}")
    public ResponseEntity<?> updateById(@PathVariable("uid") String uid, @RequestBody @Valid CreateOnlineCourseRequest onlineRequest) {
        return new ResponseEntity<>(this.courseOnlineService.updateById(UUID.fromString(uid), onlineRequest), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<?> deleteById(@PathVariable("uid") String uid, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.deleteById(UUID.fromString(uid)), HttpStatus.ACCEPTED);
            case "online":
                return new ResponseEntity<>(this.courseOnlineService.deleteById(UUID.fromString(uid)), HttpStatus.ACCEPTED);
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }
}
