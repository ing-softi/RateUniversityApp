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

    @CrossOrigin("*")
    @GetMapping("/delete")
    public void delete( @RequestParam Integer courseId,@RequestParam Integer userId ){
        courseService.updateCourse(courseId,-1);
        courseService.deleteUserCourseRelate(courseId,userId);
    }
    //insertUserCourseRelate
    @CrossOrigin("*")
    @GetMapping("/insert")
    public void insert( @RequestParam Integer courseId,@RequestParam Integer userId ){
        courseService.updateCourse(courseId,+1);
        courseService.insertUserCourseRelate(courseId,userId);
    }


}