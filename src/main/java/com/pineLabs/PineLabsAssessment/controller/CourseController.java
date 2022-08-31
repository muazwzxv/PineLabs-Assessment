package com.pineLabs.PineLabsAssessment.controller;

import com.pineLabs.PineLabsAssessment.exception.InvalidParameterException;
import com.pineLabs.PineLabsAssessment.request.CreateOfflineCourseRequest;
import com.pineLabs.PineLabsAssessment.service.ICourseOfflineService;
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

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.findAllActiveCourses(), HttpStatus.OK);
            case "online":
                /*
                 * TODO: response for online courses
                 */
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
                /*
                 * TODO: response for online courses
                 */
                return null;
            default:
                throw new InvalidParameterException();
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateOfflineCourseRequest request, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.create(request), HttpStatus.CREATED);
            case "online":
                /*
                 * TODO: response for online courses
                 */
                return null;
            default:
                throw new InvalidParameterException();
        }
    }

    @PutMapping("/{uid}")
    public ResponseEntity<?> updateById(@PathVariable("uid") String uid, @RequestParam(name = "status") String status, @RequestBody @Valid CreateOfflineCourseRequest request) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.updateById(UUID.fromString(uid), request), HttpStatus.ACCEPTED);
//                return new ResponseEntity<>(this.courseOfflineService.updateByIdJpa(UUID.fromString(uid), request), HttpStatus.ACCEPTED);
            case "online":
                /*
                 * TODO: response for online courses
                 */
                return null;
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<?> deleteById(@PathVariable("uid") String uid, @RequestParam(name = "status") String status) {
        switch (status) {
            case "offline":
                return new ResponseEntity<>(this.courseOfflineService.deleteById(UUID.fromString(uid)), HttpStatus.ACCEPTED);
            case "online":
                /*
                 * TODO: response for online courses
                 */
                return null;
            default:
                throw new RuntimeException("Invalid arguments");
        }
    }
}
