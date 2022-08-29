package com.pineLabs.PineLabsAssessment.controller;

import com.pineLabs.PineLabsAssessment.service.ICourseOfflineService;
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

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.findAll(), HttpStatus.OK);
            case "online":
                return null;
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
                return null;
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }
}
