package rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rate.dto.CourseRegistrationStatus;
import rate.model.Course;
import rate.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @CrossOrigin("*")
    @GetMapping()
    public List<Course> getAll() {
        return courseService.findAll();
    }


    @CrossOrigin("*")
    @GetMapping("/{userId}")
    public List<CourseRegistrationStatus> getCourseWithRegistrationStatus(@PathVariable Integer userId) {
        return courseService.findCourseRegistrationStatus(userId);
    }

}