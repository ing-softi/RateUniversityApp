package rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rate.model.Course;
import rate.repository.CourseRepo;
import rate.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @CrossOrigin("*")
    @GetMapping()
    public List<Course> getAll(){
        return courseService.findAll();
    }
}
