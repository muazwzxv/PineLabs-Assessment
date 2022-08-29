package com.pineLabs.PineLabsAssessment.controller;

import com.pineLabs.PineLabsAssessment.model.AbstractModel;
import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.service.ICourseOfflineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
               return new ResponseEntity<>(this.)
           default:
               break;
       }
       System.out.println(status);
       return null;
    }
}
