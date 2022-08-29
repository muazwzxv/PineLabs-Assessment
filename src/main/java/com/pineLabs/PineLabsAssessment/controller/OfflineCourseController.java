package com.pineLabs.PineLabsAssessment.controller;

import com.pineLabs.PineLabsAssessment.service.ICourseOfflineService;
import com.pineLabs.PineLabsAssessment.service.ICourseOnlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/courses")
@AllArgsConstructor
public class OfflineCourseController {

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
                throw new RuntimeException("Invalid arguments");
        }
    }
}
