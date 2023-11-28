package rate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rate.model.Course;
import rate.repository.CourseRepo;
import rate.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping()
    public List<Course> getAll(){
        return courseService.findAll();
    }
}
