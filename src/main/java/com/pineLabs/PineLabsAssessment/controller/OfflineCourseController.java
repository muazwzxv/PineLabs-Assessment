package com.pineLabs.PineLabsAssessment.controller;

import com.pineLabs.PineLabsAssessment.model.CourseOnline;
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

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateOfflineCourseRequest request,@RequestBody @Valid CreateOnlineCourseRequest requests, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.create(request), HttpStatus.CREATED);
            case "online":
                return new ResponseEntity<>(this.courseOnlineService.create(requests), HttpStatus.CREATED);
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }

    @PutMapping("/{uid}")
    public ResponseEntity<?> updateById(@RequestBody CourseOnline courseOnline, @PathVariable("uid") String uid, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                /*
                 * TODO: response for offline courses
                 */
            case "online":
                return new ResponseEntity<>(this.courseOnlineService.updateById(courseOnline, UUID.fromString(uid)), HttpStatus.ACCEPTED);
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }

    @DeleteMapping("/delete/{uid}")
    public ResponseEntity<?> deleteById(@PathVariable("uid") String uid, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                /*
                 * TODO: response for offline courses
                 */
            case "online":
                return new ResponseEntity<>(this.courseOnlineService.deleteById(UUID.fromString(uid)), HttpStatus.ACCEPTED);
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }
}
